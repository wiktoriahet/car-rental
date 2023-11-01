package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.Insurance;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class CarRentalOffer implements Offer{

    private InsuranceModel insuranceModel;
    private CarModel carModel;

    public CarRentalOffer(InsuranceModel insuranceModel, CarModel carModel) {
        this.insuranceModel = insuranceModel;
        this.carModel = carModel;
    }

    @Override
    public void printOffer() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Cars available: suv, economy, sedan")
                .append("\n")
                .append("Insurance packages available: Basic, Premium, Deluxe");

        System.out.println(stringBuilder);
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
        return "CarRentalOffer{" +
                "insuranceModel=" + insuranceModel +
                ", carModel=" + carModel +
                '}';
    }
}
