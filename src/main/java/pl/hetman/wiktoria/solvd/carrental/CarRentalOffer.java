package pl.hetman.wiktoria.solvd.carrental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;

public class CarRentalOffer implements IOffer {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalOffer.class);

    public CarRentalOffer() {
    }

    @Override
    public final void printOffer() {
        LOGGER.info("printOffer()");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Cars available: suv, economy, sedan")
                .append("\n")
                .append("Insurance packages available: Basic, Premium, Deluxe");

        System.out.println(stringBuilder);
        LOGGER.info("printOffer(...)");
    }

}
