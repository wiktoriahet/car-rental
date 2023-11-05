package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class SuvCar extends CarModel {

    private boolean fullSize;
    private boolean fourWheelDrive;
    private boolean premium;
    static int count;

    static {
        count = 0;
        System.out.println("Suv car static block");
    }

    public SuvCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, boolean fullSize, boolean fourWheelDrive, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay);
        this.fullSize = fullSize;
        this.fourWheelDrive = fourWheelDrive;
        this.premium = premium;
        count++;
    }

    public static void displayCount(){
        System.out.println("Suv cars in use: " + count);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Premium car: " + premium)
                .append("\n")
                .append("Four wheel drive: " + fourWheelDrive)
                .append("\n")
                .append("Full size: " + fullSize);
        System.out.println(stringBuilder);
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
                SuvCar.super.toString() + '\'' +
                "fullSize=" + fullSize +
                ", fourWheelDrive=" + fourWheelDrive +
                ", premium=" + premium +
                '}';
    }
}
