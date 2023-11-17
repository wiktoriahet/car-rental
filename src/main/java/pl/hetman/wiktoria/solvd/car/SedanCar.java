package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SedanCar extends CarModel {

    private static final Logger LOGGER = LogManager.getLogger(SedanCar.class);
    static int count;

    static {
        count = 0;
        LOGGER.info("Sedan car static block");
    }

    private boolean premium;


    public SedanCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay);
        LOGGER.info("SedanCar(" + id + ", " + carModelName + ", " + airConditioning + ", " + spareTire + ", " + feePerDay + ", " + premium + ")");
        this.premium = premium;
        count++;
        LOGGER.info("SedanCar(...)");
    }

    public static void displayCount() {
        LOGGER.info("displayCount()");
        System.out.println("Sedan cars in use: " + count);
        LOGGER.info("displayCount(...)");
    }

    @Override
    public boolean displayInformation() {
        LOGGER.info("Displaying information for SedanCar");
        boolean informationDisplayed = super.displayInformation();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Premium car: " + premium);
        LOGGER.info(stringBuilder.toString());
        return informationDisplayed;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "SedanCar{" + '\'' +
                super.toString() + '\'' +
                "premium=" + premium +
                '}';
    }
}
