package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EconomyModel {

    IBIZA("Ibiza", 200),
    ASTRA("Astra", 300),
    FOCUS("Focus", 250);

    private static final Logger LOGGER = LogManager.getLogger(EconomyModel.class);

    static {
        LOGGER.info("EconomyModel() static block");
        System.out.println("Checking available economy cars models");
        LOGGER.info("EconomyModel(...)");
    }

    private final String model;
    private final double pricePerDay;

    EconomyModel(String model, double pricePerDay) {
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
