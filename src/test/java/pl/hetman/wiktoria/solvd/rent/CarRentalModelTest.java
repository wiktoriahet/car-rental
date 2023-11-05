package pl.hetman.wiktoria.solvd.rent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.EconomyCar;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

class CarRentalModelTest {

    @Test
    void rentACar() throws CarRentalException {
        //given
        //InsuranceModel insuranceModel = new InsuranceModel(UniqueIdGenerator.generateId(), "Premium", true, true, true, 200);
        InsuranceModel insuranceModel = null;
        CarModel carModel = new EconomyCar(UniqueIdGenerator.generateId(), "Ford", true, true, 120);
        //CarModel carModel = null;
        CarRentalModel carRentalModel = new CarRentalModel(UniqueIdGenerator.generateId(), 7, carModel, insuranceModel);

        //when
        boolean rentedCar = carRentalModel.rentACar(carModel, insuranceModel);

        //then
        Assertions.assertEquals(true, rentedCar);

    }
}