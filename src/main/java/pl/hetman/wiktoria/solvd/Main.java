package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.SedanCar;
import pl.hetman.wiktoria.solvd.car.SuvCar;
import pl.hetman.wiktoria.solvd.carrental.CarRentalOffer;
import pl.hetman.wiktoria.solvd.company.CompanyStructure;
import pl.hetman.wiktoria.solvd.company.Department;
import pl.hetman.wiktoria.solvd.customlinkedlist.GenericLinkedList;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.person.Customer;
import pl.hetman.wiktoria.solvd.person.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) throws PersonException {


        List<CarModel> existingCars = new ArrayList<>();

        CarRentalOffer carRentalOffer = new CarRentalOffer();
        carRentalOffer.printOffer();

        List<Customer> customers = new ArrayList<>();

        InsuranceModel insuranceDeluxe = new InsuranceModel(UniqueIdGenerator.generateId(), "Deluxe", true, true, true, 300);
        InsuranceModel insuranceBasic = new InsuranceModel(UniqueIdGenerator.generateId(), "Basic", false, true, false, 100);

        SuvCar suvCarOne = new SuvCar(UniqueIdGenerator.generateId(), "tuareg", true, true, 650, true, true, true);
        existingCars.add(suvCarOne);

        suvCarOne.displayInformation();

        CarModel suvCarTwo = new SuvCar(UniqueIdGenerator.generateId(), "tuareg", false, true, 650, true, true, true);
        suvCarTwo.displayInformation();
        existingCars.add(suvCarTwo);

        SuvCar.displayCount();

        Customer customerJanKowalski = new Customer(UniqueIdGenerator.generateId(), "Jan", "Kowalski", insuranceDeluxe, suvCarOne);
        customers.add(customerJanKowalski);

        Customer customerAdamAdamski = new Customer(UniqueIdGenerator.generateId(), "Adam", "Adamski", insuranceBasic, suvCarTwo);
        customers.add(customerAdamAdamski);

        CarModel sedanCar = new SedanCar(UniqueIdGenerator.generateId(), "Fiat", true, true, 400, false);
        existingCars.add(sedanCar);


        Employee employeeAnnaNowak = new Employee(UniqueIdGenerator.generateId(), "Anna", "Nowak", customers);
        Employee employeeBeataKowalska = new Employee(UniqueIdGenerator.generateId(), "Beata", "Kowalska", customers);
        Employee employeeTomTomski = new Employee(UniqueIdGenerator.generateId(), "Tom", "Tomski", customers);
        Employee employeeJanNowak = new Employee(UniqueIdGenerator.generateId(), "Jan", "Nowak", customers);
        Employee employeeAdamMickiewicz = new Employee(UniqueIdGenerator.generateId(), "Adam", "Mickiewicz", customers);
        Employee employeeJanKochanowski = new Employee(UniqueIdGenerator.generateId(), "Jan", "Kochanowski", customers);
        Employee employeeBoleslawPrus = new Employee(UniqueIdGenerator.generateId(), "Boleslaw", "Prus", customers);

        Department departmentParis = new Department("Paris department");
        Department departmentBerlin = new Department("Paris department");
        Department departmentLondon = new Department("Berlin department");

        CompanyStructure companyStructure = new CompanyStructure();

        companyStructure.addToCompanyStructure(employeeAnnaNowak, departmentParis);
        companyStructure.addToCompanyStructure(employeeBeataKowalska, departmentParis);
        companyStructure.addToCompanyStructure(employeeTomTomski, departmentParis);

        companyStructure.addToCompanyStructure(employeeJanNowak, departmentBerlin);
        companyStructure.addToCompanyStructure(employeeAdamMickiewicz,departmentBerlin);

        companyStructure.addToCompanyStructure(employeeJanKochanowski, departmentLondon);
        companyStructure.addToCompanyStructure(employeeBoleslawPrus, departmentLondon);

        companyStructure.printCompanyStructure();

        GenericLinkedList<Employee> employeeGenericLinkedList = new GenericLinkedList<>();
        GenericLinkedList.insert(employeeGenericLinkedList, employeeAdamMickiewicz);
        GenericLinkedList.insert(employeeGenericLinkedList, employeeJanKochanowski);
        GenericLinkedList.insert(employeeGenericLinkedList, employeeBoleslawPrus);
        GenericLinkedList.insert(employeeGenericLinkedList, employeeJanNowak);
        GenericLinkedList.printList(employeeGenericLinkedList);


    }
}