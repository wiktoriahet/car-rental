package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class EconomyCar extends CarModel{

    static int count;

    static{
        count = 0;
        System.out.println("Current amount of economy cars in use: " + count);
    }

    public EconomyCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, InsuranceModel insuranceModel) {
        super(id, carModelName, airConditioning, spareTire, feePerDay, insuranceModel);
        count++;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
