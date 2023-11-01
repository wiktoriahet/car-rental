package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class SuvCar extends CarModel{

    private boolean fullSize;
    private boolean fourWheelDrive;
    private boolean premium;

    public SuvCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, InsuranceModel insuranceModel, boolean fullSize, boolean fourWheelDrive, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay, insuranceModel);
        this.fullSize = fullSize;
        this.fourWheelDrive = fourWheelDrive;
        this.premium = premium;
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
