package pl.hetman.wiktoria.solvd;

public interface Car {

    void displayInformation();
    double getPrice(int days, InsuranceModel insuranceModel);
    void rentCar(int days, InsuranceModel insuranceModel);

}
