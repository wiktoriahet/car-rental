package pl.hetman.wiktoria.solvd.person;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class Customer extends Person{

    private Long id;
    private String name;
    private String surname;
    private InsuranceModel insuranceModel;
    private CarModel carModel;

    public Customer(Long id, String name, String surname, InsuranceModel insuranceModel, CarModel carModel) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.insuranceModel = insuranceModel;
        this.carModel = carModel;
    }

    @Override
    void printInformation() {

    }
}
