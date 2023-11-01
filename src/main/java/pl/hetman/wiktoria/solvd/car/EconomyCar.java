package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class EconomyCar extends CarModel{

    public EconomyCar(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, InsuranceModel insuranceModel) {
        super(id, carModelName, airConditioning, spareTire, feePerDay, insuranceModel);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
    }

    @Override
    public double getPrice(int days, InsuranceModel insuranceModel) {
        return super.getPrice(days, insuranceModel);
    }

    @Override
    public void rentCar(int days, InsuranceModel insuranceModel) {
        super.rentCar(days, insuranceModel);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getCarModelName() {
        return super.getCarModelName();
    }

    @Override
    public void setCarModelName(String carModelName) {
        super.setCarModelName(carModelName);
    }

    @Override
    public boolean isAirConditioning() {
        return super.isAirConditioning();
    }

    @Override
    public void setAirConditioning(boolean airConditioning) {
        super.setAirConditioning(airConditioning);
    }

    @Override
    public boolean isSpareTire() {
        return super.isSpareTire();
    }

    @Override
    public void setSpareTire(boolean spareTire) {
        super.setSpareTire(spareTire);
    }

    @Override
    public double getFeePerDay() {
        return super.getFeePerDay();
    }

    @Override
    public void setFeePerDay(double feePerDay) {
        super.setFeePerDay(feePerDay);
    }

    @Override
    public InsuranceModel getInsuranceModel() {
        return super.getInsuranceModel();
    }

    @Override
    public void setInsuranceModel(InsuranceModel insuranceModel) {
        super.setInsuranceModel(insuranceModel);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
