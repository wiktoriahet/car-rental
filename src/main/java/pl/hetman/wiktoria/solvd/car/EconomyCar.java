package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EconomyCar extends CarModel {

    private static final Logger LOGGER = LogManager.getLogger(EconomyCar.class);

    static int count;

    static{
        count = 0;
        LOGGER.info("Economy car static block");
        //System.out.println("Economy car static block");
    }

    public EconomyCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay) {
        super(id, carModelName, airConditioning, spareTire, feePerDay);
        LOGGER.info("Economy("+id+", "+carModelName+", "+spareTire+", "+feePerDay+")");
        count++;
        LOGGER.info("Economy(...)");
    }

    public static void displayCount(){
        System.out.println("Economy cars in use: " + count);
    }

    @Override
    public String toString() {
        return "EconomyCar{" +
                "id=" + getId() +
                ", carModelName='" + getCarModelName() + '\'' +
                ", airConditioning=" + isAirConditioning() +
                ", spareTire=" + isSpareTire() +
                ", feePerDay=" + getFeePerDay() +
                '}';
    }
}
