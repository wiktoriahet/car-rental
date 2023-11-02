package pl.hetman.wiktoria.solvd.carrental;

public class CarRentalOffer implements IOffer {

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
