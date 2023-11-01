package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public interface Car {

    void displayInformation();
    double getPrice(int days, InsuranceModel insuranceModel);
    void rentCar(int days, InsuranceModel insuranceModel);

}