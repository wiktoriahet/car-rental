package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarList;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.EconomyCar;
import pl.hetman.wiktoria.solvd.car.EconomyModel;
import pl.hetman.wiktoria.solvd.car.SedanCar;
import pl.hetman.wiktoria.solvd.car.SedanModel;
import pl.hetman.wiktoria.solvd.car.SuvCar;
import pl.hetman.wiktoria.solvd.car.SuvModel;
import pl.hetman.wiktoria.solvd.carrental.CarRentalOffer;
import pl.hetman.wiktoria.solvd.company.CompanyStructure;
import pl.hetman.wiktoria.solvd.company.Department;
import pl.hetman.wiktoria.solvd.customlinkedlist.GenericLinkedList;
import pl.hetman.wiktoria.solvd.exceptions.DepartmentException;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceCatalogue;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.person.Customer;
import pl.hetman.wiktoria.solvd.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) throws PersonException, DepartmentException {

        //list to hold all existing cars
        List<CarModel> existingCars = new ArrayList<>();

        //list to hold all insurance packages
        List<InsuranceModel> insurancePackages = new ArrayList<>();

        //creating insurance packages and adding them to the list
        InsuranceModel insuranceBasic = new InsuranceModel(InsuranceCatalogue.BASIC);
        insurancePackages.add(insuranceBasic);
        InsuranceModel insuranceExtra = new InsuranceModel(InsuranceCatalogue.EXTRA);
        insurancePackages.add(insuranceExtra);
        InsuranceModel insuranceDeluxe = new InsuranceModel(InsuranceCatalogue.DELUXE);
        insurancePackages.add(insuranceDeluxe);

        //printing information about insurances
        System.out.println("..................");
        System.out.println();

        StringBuilder informationBasic = insuranceBasic.printInsuranceInformation(InsuranceCatalogue.BASIC);
        System.out.println(informationBasic);
        StringBuilder informationExtra = insuranceExtra.printInsuranceInformation(InsuranceCatalogue.EXTRA);
        System.out.println(informationExtra);
        StringBuilder informationDeluxe = insuranceDeluxe.printInsuranceInformation(InsuranceCatalogue.DELUXE);
        System.out.println(informationDeluxe);

        System.out.println();
        System.out.println("..................");

        //creating cars available to rent and adding them to the list

        //economy cars
        System.out.println("..................");
        System.out.println();

        CarModel economyCarOne = new EconomyCar(UniqueIdGenerator.generateId(), EconomyModel.IBIZA.getModel(), true, true, EconomyModel.IBIZA.getPricePerDay());
        existingCars.add(economyCarOne);
        CarModel economyCarTwo = new EconomyCar(UniqueIdGenerator.generateId(), EconomyModel.FOCUS.getModel(), true, false, EconomyModel.FOCUS.getPricePerDay());
        existingCars.add(economyCarTwo);
        CarModel economyCarThree = new EconomyCar(UniqueIdGenerator.generateId(), EconomyModel.ASTRA.getModel(), false, true, EconomyModel.ASTRA.getPricePerDay());
        existingCars.add(economyCarThree);

        System.out.println();
        System.out.println("..................");

        //sedan cars
        System.out.println("..................");
        System.out.println();

        CarModel sedanCarOne = new SedanCar(UniqueIdGenerator.generateId(), SedanModel.PASSAT.getModel(), true, true, SedanModel.PASSAT.getPricePerDay(), true);
        existingCars.add(sedanCarOne);
        CarModel sedanCarTwo = new SedanCar(UniqueIdGenerator.generateId(), SedanModel.TOLEDO.getModel(), true, true, SedanModel.TOLEDO.getPricePerDay(), false);
        existingCars.add(sedanCarTwo);
        CarModel sedanCarThree = new SedanCar(UniqueIdGenerator.generateId(), SedanModel.MONDEO.getModel(), true, true, SedanModel.MONDEO.getPricePerDay(), false);
        existingCars.add(sedanCarThree);

        System.out.println();
        System.out.println("..................");

        //suv cars
        System.out.println("..................");
        System.out.println();
        CarModel suvCarOne = new SuvCar(UniqueIdGenerator.generateId(), SuvModel.CAYENNE.getModel(), false, false, SuvModel.CAYENNE.getPricePerDay(), true, false, true);
        existingCars.add(suvCarOne);
        CarModel suvCarTwo = new SuvCar(UniqueIdGenerator.generateId(), SuvModel.TOUAREG.getModel(), true, false, SuvModel.TOUAREG.getPricePerDay(), true, true, true);
        existingCars.add(suvCarTwo);
        CarModel suvCarThree = new SuvCar(UniqueIdGenerator.generateId(), SuvModel.FREEMONT.getModel(), true, true, SuvModel.FREEMONT.getPricePerDay(), true, true, true);
        existingCars.add(suvCarThree);

        //adding list of existing cars to collection of car lists
        CarList carList = new CarList(existingCars);
        carList.printCarList();

        System.out.println();
        System.out.println("..................");

        //displaying information about cars
        System.out.println("..................");
        System.out.println();

        economyCarOne.displayInformation();
        sedanCarTwo.displayInformation();
        suvCarThree.displayInformation();

        System.out.println();
        System.out.println("..................");

        //displaying amount of all cars in existence
        System.out.println("..................");
        System.out.println();

        EconomyCar.displayCount();
        SuvCar.displayCount();
        SedanCar.displayCount();

        System.out.println();
        System.out.println("..................");

        //creating car rental offer that consists all existing cars and insurance packages
        //and printing the offer
        System.out.println("..................");
        System.out.println();

        CarRentalOffer carRentalOffer = new CarRentalOffer(existingCars, insurancePackages);
        carRentalOffer.printOffer();

        System.out.println();
        System.out.println("..................");

        //creating list to hold all customers
        List<Customer> customers = new ArrayList<>();

        //creating customers and adding them to the list
        System.out.println("..................");
        System.out.println();

        Customer customerJanKowalski = new Customer(UniqueIdGenerator.generateId(), "Jan", "Kowalski", insuranceBasic, economyCarOne);
        customers.add(customerJanKowalski);
        Customer customerAdamAdamski = new Customer(UniqueIdGenerator.generateId(), "Adam", "Adamski", insuranceExtra, suvCarTwo);
        customers.add(customerAdamAdamski);
        Customer customerJohnJohnson = new Customer(UniqueIdGenerator.generateId(), "John", "Johnson", insuranceDeluxe, sedanCarThree);
        customers.add(customerJohnJohnson);

        System.out.println();
        System.out.println("..................");

        //creating employees
        System.out.println("..................");
        System.out.println();

        Employee employeeAnnaNowak = new Employee(UniqueIdGenerator.generateId(), "Anna", "Nowak", customers);
        Employee employeeBeataKowalska = new Employee(UniqueIdGenerator.generateId(), "Beata", "Kowalska", customers);
        Employee employeeTomTomski = new Employee(UniqueIdGenerator.generateId(), "Tom", "Tomski", customers);
        Employee employeeJanNowak = new Employee(UniqueIdGenerator.generateId(), "Jan", "Nowak", customers);
        Employee employeeAdamMickiewicz = new Employee(UniqueIdGenerator.generateId(), "Adam", "Mickiewicz", customers);
        Employee employeeJanKochanowski = new Employee(UniqueIdGenerator.generateId(), "Jan", "Kochanowski", customers);
        Employee employeeBoleslawPrus = new Employee(UniqueIdGenerator.generateId(), "Boleslaw", "Prus", customers);

        System.out.println();
        System.out.println("..................");

        //creating departments
        System.out.println("..................");
        System.out.println();

        Department departmentParis = new Department("Paris department");
        Department departmentBerlin = new Department("Berlin department");
        Department departmentLondon = new Department("London department");

        System.out.println();
        System.out.println("..................");

        //creating company structure and adding employees and departments to the structure
        System.out.println("..................");
        System.out.println();

        CompanyStructure companyStructure = new CompanyStructure();

        companyStructure.addToCompanyStructure(employeeAnnaNowak, departmentParis);
        companyStructure.addToCompanyStructure(employeeBeataKowalska, departmentParis);
        companyStructure.addToCompanyStructure(employeeTomTomski, departmentParis);
        companyStructure.addToCompanyStructure(employeeJanNowak, departmentBerlin);
        companyStructure.addToCompanyStructure(employeeAdamMickiewicz, departmentBerlin);
        companyStructure.addToCompanyStructure(employeeJanKochanowski, departmentLondon);
        companyStructure.addToCompanyStructure(employeeBoleslawPrus, departmentLondon);

        companyStructure.printCompanyStructure();

        System.out.println();
        System.out.println("..................");

        //adding employees to the generic linked list
        System.out.println("..................");
        System.out.println();

        GenericLinkedList<Employee> employeeGenericLinkedList = new GenericLinkedList<>();
        GenericLinkedList.insert(employeeGenericLinkedList, employeeAdamMickiewicz);
        GenericLinkedList.insert(employeeGenericLinkedList, employeeJanKochanowski);
        GenericLinkedList.insert(employeeGenericLinkedList, employeeBoleslawPrus);
        GenericLinkedList.insert(employeeGenericLinkedList, employeeJanNowak);
        GenericLinkedList.printList(employeeGenericLinkedList);

        System.out.println();
        System.out.println("..................");

        //1. using predicate with lambda to check if car has air conditioning
        System.out.println("..................");
        System.out.println();

        Predicate<CarModel> carModelPredicate = carModel -> carModel.isAirConditioning() == true;
        boolean hasAirConditioning = carModelPredicate.test(suvCarOne);
        System.out.println("Does chosen car have air conditioning? " + hasAirConditioning);

        System.out.println();
        System.out.println("..................");

        //2. using streams with lambda to display all freemont cars from existing cars list
        System.out.println("..................");
        System.out.println();

        List<CarModel> suvCars = existingCars.stream()
                .filter(cars -> cars.getCarModelName() == SuvModel.FREEMONT.getModel())
                .collect(Collectors.toList());

        System.out.println(suvCars);

        System.out.println();
        System.out.println("..................");

        //3. using Runnable with Lambda to print information about departments
        System.out.println("..................");
        System.out.println();

        Runnable printDepartmentInfo = () -> System.out.println(departmentBerlin.getDepartmentName());
        printDepartmentInfo.run();

        System.out.println();
        System.out.println("..................");

        //4. Using predicate to check if Anna Nowak is in company structure
        System.out.println("..................");
        System.out.println();

        Predicate<CompanyStructure> checkCompanyStructure = department -> department.getCompanyStructure().containsKey(employeeAnnaNowak.getId());
        boolean isInCompanyStructure = checkCompanyStructure.test(companyStructure);
        System.out.println("Is " + employeeAnnaNowak.getName() + " in company structure? " + isInCompanyStructure);

        System.out.println();
        System.out.println("..................");

        //5. Using streams to print customers that have Extra insurance
        System.out.println("..................");
        System.out.println();

        List<Customer> customersExtra = customers.stream()
                .filter(customersFilter -> customersFilter.getInsuranceModel().getInsurancePackageName().equals(InsuranceCatalogue.EXTRA.getPackageName()))
                .collect(Collectors.toList());

        System.out.println(customersExtra);

        System.out.println();
        System.out.println("..................");

    }
}