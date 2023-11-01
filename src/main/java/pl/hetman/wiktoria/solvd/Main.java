package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.EconomyCar;
import pl.hetman.wiktoria.solvd.car.SuvCar;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.Insurance;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.person.Customer;
import pl.hetman.wiktoria.solvd.person.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        InsuranceModel insuranceDeluxe = new InsuranceModel(UniqueIdGenerator.generateId(), "Deluxe", true, true, true, 300);
        InsuranceModel insuranceBasic = new InsuranceModel(UniqueIdGenerator.generateId(), "Basic", false, true, false, 100);

        SuvCar suvCarOne = new SuvCar(UniqueIdGenerator.generateId(), "tuareg", true, true, 650, insuranceDeluxe, true, true, true);

        suvCarOne.displayInformation();

        CarModel suvCarTwo = new SuvCar(UniqueIdGenerator.generateId(), "tuareg", false, true, 650, insuranceDeluxe, true, true, true);
        suvCarTwo.displayInformation();

        SuvCar.displayCount();

        Customer customerJanKowalski = new Customer(UniqueIdGenerator.generateId(), "Jan", "Kowalski", insuranceDeluxe, suvCarOne);
        customers.add(customerJanKowalski);

        Customer customerAdamAdamski = new Customer(UniqueIdGenerator.generateId(), "Adam", "Adamski", insuranceBasic, suvCarTwo);
        customers.add(customerAdamAdamski);


        Employee employeeAnnaNowak = new Employee(UniqueIdGenerator.generateId(), "Anna", "Nowak", "Paris", customers);





    }
}