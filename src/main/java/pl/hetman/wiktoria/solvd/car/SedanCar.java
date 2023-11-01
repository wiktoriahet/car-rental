package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class SedanCar extends CarModel{

    private boolean premium;

    public SedanCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, InsuranceModel insuranceModel, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay, insuranceModel);
        this.premium = premium;
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
