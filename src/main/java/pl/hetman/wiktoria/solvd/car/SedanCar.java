package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class SedanCar extends CarModel {

    private static final Logger LOGGER = LogManager.getLogger(SedanCar.class);

    private boolean premium;
    static int count;

    static{
        count = 0;
        System.out.println("Sedan car static block");
    }


    public SedanCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay);
        LOGGER.always().log("SedanCar("+id+", "+carModelName+", "+airConditioning+", "+spareTire+", "+feePerDay+", "+premium+")");
        this.premium = premium;
        count++;
        LOGGER.always().log("SedanCar(...)");
    }

    public static void displayCount(){
        LOGGER.always().log("displayCount()");
        System.out.println("Sedan cars in use: " + count);
        LOGGER.always().log("displayCount(...)");
    }

    @Override
    public boolean displayInformation() {
        LOGGER.always().log("displayInformation()");
        super.displayInformation();
        boolean informationDisplayed = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Premium car: " + premium);
        System.out.println(stringBuilder);
        LOGGER.always().log("displayInformation(...)");
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
                SedanCar.super.toString() + '\'' +
                "premium=" + premium +
                '}';
    }
}
