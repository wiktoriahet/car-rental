package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum SedanModel {

    PASSAT("Passat", 100),
    MONDEO("Mondeo", 200),
    TOLEDO("Toledo", 300);

    private static final Logger LOGGER = LogManager.getLogger(SedanModel.class);

    static {
        LOGGER.info("SedanModel() static block");
        System.out.println("Checking available sedan cars models");
        LOGGER.info("SedanModel(...)");
    }

    private final String model;
    private final double pricePerDay;

    SedanModel(String model, double pricePerDay) {
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
