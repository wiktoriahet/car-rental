package pl.hetman.wiktoria.solvd.rent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.EconomyCar;
import pl.hetman.wiktoria.solvd.car.EconomyModel;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;
import pl.hetman.wiktoria.solvd.carrental.rent.RentalStatus;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceCatalogue;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

class CarRentalModelTest {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void validateRentCar() throws CarRentalException {
        //given
        InsuranceModel insuranceModel = new InsuranceModel();
        insuranceModel.chooseInsurance(InsuranceCatalogue.BASIC);
        //InsuranceModel insuranceModel = null;
        CarModel carModel = new EconomyCar(UniqueIdGenerator.generateId(), EconomyModel.FOCUS.getModel(), true, true, EconomyModel.FOCUS.getPricePerDay());
        //CarModel carModel = null;
        RentalStatus rentalStatusAvailable = RentalStatus.AVAILABLE;
        RentalStatus rentalStatusNotAvailable = RentalStatus.NOT_AVAILABLE;
        CarRentalModel carRentalModelNotValidated = new CarRentalModel(UniqueIdGenerator.generateId(), 7, carModel, insuranceModel, rentalStatusNotAvailable);
        CarRentalModel carRentalModelValidated = new CarRentalModel(UniqueIdGenerator.generateId(), 7, carModel, insuranceModel, rentalStatusAvailable);

        //when
        boolean rentedCarUnsuccesfully = carRentalModelNotValidated.rentACar(carModel, insuranceModel);
        boolean rentedCarSuccessfully = carRentalModelValidated.rentACar(carModel, insuranceModel);

        //then
        Assertions.assertTrue(rentedCarSuccessfully, "Car couldn't be rented successfully");
        Assertions.assertFalse(rentedCarUnsuccesfully, "Car should be rented successfully");

    }

    @Test
    void checkPriceCalculations() {
        //given
        InsuranceModel insuranceModel = new InsuranceModel();
        insuranceModel.chooseInsurance(InsuranceCatalogue.BASIC);
        CarModel carModel = new EconomyCar(UniqueIdGenerator.generateId(), EconomyModel.IBIZA.getModel(), true, true, EconomyModel.IBIZA.getPricePerDay());
        RentalStatus rentalStatusAvailable = RentalStatus.AVAILABLE;
        CarRentalModel carRentalModel = new CarRentalModel(UniqueIdGenerator.generateId(), 7, carModel, insuranceModel, rentalStatusAvailable);

        //when
        double priceExpected = InsuranceCatalogue.BASIC.getPrice() + (carModel.getFeePerDay() * carRentalModel.getDays());
        double priceCalculated = carRentalModel.getRentalPrice(carModel, insuranceModel);

        //then
        Assertions.assertEquals(priceExpected, priceCalculated, "Prices are not equal");

    }
}