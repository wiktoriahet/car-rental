package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//third task review
public class SuvCar extends CarModel {

    private static final Logger LOGGER = LogManager.getLogger(SuvCar.class);

    private boolean fullSize;
    private boolean fourWheelDrive;
    private boolean premium;
    static int count;

    static {
        count = 0;
        LOGGER.info("Suv car static block");
    }

    public SuvCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, boolean fullSize, boolean fourWheelDrive, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay);
        LOGGER.info("SuvCar("+id+", "+carModelName+", "+airConditioning+", "+spareTire+", "+feePerDay+", "+fullSize+", "+fourWheelDrive+", "+premium+")");
        this.fullSize = fullSize;
        this.fourWheelDrive = fourWheelDrive;
        this.premium = premium;
        count++;
        LOGGER.info("SuvCar(...)");
    }

    public static void displayCount(){
        LOGGER.info("displayCount()");
        System.out.println("Suv cars in use: " + count);
        LOGGER.info("displayCount(...)");
    }

    @Override
    public boolean displayInformation() {
        LOGGER.info("Displaying information for SuvCar");
        boolean informationDisplayed = super.displayInformation();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Premium car: ").append(premium).append("\n")
                .append("Four wheel drive: ").append(fourWheelDrive).append("\n")
                .append("Full size: ").append(fullSize);
        LOGGER.info(stringBuilder.toString());
        return informationDisplayed;
    }

    public boolean isFullSize() {
        return fullSize;
    }

    public void setFullSize(boolean fullSize) {
        this.fullSize = fullSize;
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "SuvCar{" + '\'' +
                super.toString() + '\'' +
                "fullSize=" + fullSize +
                ", fourWheelDrive=" + fourWheelDrive +
                ", premium=" + premium +
                '}';
    }
}
