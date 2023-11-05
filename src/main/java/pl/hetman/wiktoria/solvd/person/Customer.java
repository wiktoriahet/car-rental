package pl.hetman.wiktoria.solvd.person;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

import java.util.Objects;

public class Customer extends PersonModel {

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
        printInformation();
    }

    @Override
    void printInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Customer ID: " + id)
                .append("\n")
                .append("Name and surname: " + name + " " + surname)
                .append("\n")
                .append("Insurance: " + insuranceModel.getPackageName())
                .append("\n")
                .append("Car id and name: " + carModel.getId() + " " + carModel.getCarModelName());

        System.out.println(stringBuilder);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getId().equals(customer.getId()) && getName().equals(customer.getName()) && getSurname().equals(customer.getSurname()) && getInsuranceModel().equals(customer.getInsuranceModel()) && getCarModel().equals(customer.getCarModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getInsuranceModel(), getCarModel());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", insuranceModel=" + insuranceModel +
                ", carModel=" + carModel +
                '}';
    }
}
