package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum SuvModel {

    TOUAREG("Touareg", 200),
    FREEMONT("Freemont", 300),
    CAYENNE("Cayenne", 400);

    private static final Logger LOGGER = LogManager.getLogger(SuvModel.class);

    static {
        LOGGER.info("SuvModel() static block");
        System.out.println("Checking available suv cars models");
        LOGGER.info("SuvModel(...)");
    }

    private final String model;
    private final double pricePerDay;

    SuvModel(String model, double pricePerDay) {
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}
