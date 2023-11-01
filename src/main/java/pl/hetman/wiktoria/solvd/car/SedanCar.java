package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class SedanCar extends CarModel{

    private boolean premium;
    static int count;

    static{
        count = 0;
        System.out.println("Current amount of sedan cars in use: " + count);
    }


    public SedanCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, InsuranceModel insuranceModel, boolean premium) {
        super(id, carModelName, airConditioning, spareTire, feePerDay, insuranceModel);
        this.premium = premium;
        count++;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Premium car: " + premium);
        System.out.println(stringBuilder);
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
