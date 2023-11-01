package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.Insurance;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class CarRentalOffer implements Offer{

    public CarRentalOffer() {
    }

    @Override
    public final void printOffer() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Cars available: suv, economy, sedan")
                .append("\n")
                .append("Insurance packages available: Basic, Premium, Deluxe");

        System.out.println(stringBuilder);
    }

}
