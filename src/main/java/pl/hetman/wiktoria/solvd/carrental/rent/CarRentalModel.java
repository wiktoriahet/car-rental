package pl.hetman.wiktoria.solvd.carrental.rent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.CarException;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.exceptions.InsuranceException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.logs.FileLogger;

public class CarRentalModel implements IRental {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalModel.class);

    private Long id;
    private int days;
    private CarModel carModel;
    private InsuranceModel insuranceModel;

    public CarRentalModel(Long id, int days, CarModel carModel, InsuranceModel insuranceModel) {
        LOGGER.info("CarRentalModel(" + id + ", " + days + ", " + carModel + ", " + insuranceModel + ")");
        this.id = id;
        this.days = days;
        this.carModel = carModel;
        this.insuranceModel = insuranceModel;
        LOGGER.info("CarRentalModel(...)");
    }

    @Override
    public boolean rentACar(CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException {
        LOGGER.info("rentACar(" + carModel + ", " + insuranceModel + ")");
        StringBuilder stringBuilder = new StringBuilder();
        boolean rented = false;

        if (insuranceModel == null) {
            InsuranceException insuranceException = new InsuranceException("Problem with insurance while renting a car" + "\n");
            FileLogger.logToFile(insuranceException.getMessage());
            LOGGER.error(insuranceException.getMessage());
            throw insuranceException;
        } else if (carModel == null) {
            CarException carException = new CarException("Problem with car while renting a car" + "\n");
            FileLogger.logToFile(carException.getMessage());
            LOGGER.error(carException.getMessage());
            throw carException;
        }
        stringBuilder
                .append("Car " + carModel.getId() + " rented for " + days + "day(s)")
                .append("\n")
                .append("Total price =  " + getPrice(carModel, insuranceModel));

        rented = true;
        System.out.println(stringBuilder);
        LOGGER.info("rentACar(...)");
        return rented;
    }

    @Override
    public double getPrice(CarModel carModel, InsuranceModel insuranceModel) {
        LOGGER.info("getPrice(" + carModel + ", " + insuranceModel + ")");
        double priceOfInsurance = insuranceModel.getPrice();
        double priceInTotal = priceOfInsurance + (days * carModel.getFeePerDay());
        LOGGER.info("getPrice(...)");
        return priceInTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public InsuranceModel getInsuranceModel() {
        return insuranceModel;
    }

    public void setInsuranceModel(InsuranceModel insuranceModel) {
        this.insuranceModel = insuranceModel;
    }

    @Override
    public String toString() {
        return "CarRentalModel{" +
                "id=" + id +
                ", days=" + days +
                ", carModel=" + carModel +
                ", insuranceModel=" + insuranceModel +
                '}';
    }
}
