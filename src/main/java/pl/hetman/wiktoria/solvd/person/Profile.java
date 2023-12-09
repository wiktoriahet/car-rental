package pl.hetman.wiktoria.solvd.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class Profile {

    private static final Logger LOGGER = LogManager.getLogger(Profile.class);

    private String name;
    private String surname;
    private InsuranceModel insuranceModel;
    private CarModel carModel;

    public Profile() {
    }

    public Profile(String name, String surname, InsuranceModel insuranceModel, CarModel carModel) {
        this.name = name;
        this.surname = surname;
        this.insuranceModel = insuranceModel;
        this.carModel = carModel;
    }

    public Customer createAProfile(String name, String surname, InsuranceModel insuranceModel, CarModel carModel) throws PersonException {
        LOGGER.info("createAProfile(" + name + " " + surname + ")");
        System.out.println("Created new profile of: " + name + " " + surname);
        LOGGER.info("createAProfile(...)");
        return new Customer(UniqueIdGenerator.generateId(), name, surname, insuranceModel, carModel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public InsuranceModel getInsuranceModel() {
        return insuranceModel;
    }

    public void setInsuranceModel(InsuranceModel insuranceModel) {
        this.insuranceModel = insuranceModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", surnaname='" + surname + '\'' +
                ", insuranceModel=" + insuranceModel +
                ", carModel=" + carModel +
                '}';
    }
}
