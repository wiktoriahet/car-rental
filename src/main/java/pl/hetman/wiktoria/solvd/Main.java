package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.EconomyCar;
import pl.hetman.wiktoria.solvd.car.SuvCar;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.Insurance;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class Main {
    public static void main(String[] args) {

        InsuranceModel insurance = new InsuranceModel(UniqueIdGenerator.generateId(), "Deluxe", true, true, true, 300);

        SuvCar suvCarOne = new SuvCar(UniqueIdGenerator.generateId(), "tuareg", true, true, 650, insurance, true, true, true);

        suvCarOne.displayInformation();

        CarModel suvCarTwo = new SuvCar(UniqueIdGenerator.generateId(), "tuareg", false, true, 650, insurance, true, true, true);
        suvCarTwo.displayInformation();

        SuvCar.displayCount();





    }
}