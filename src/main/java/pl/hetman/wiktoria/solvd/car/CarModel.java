package pl.hetman.wiktoria.solvd.car;

import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

import java.util.Objects;

public class CarModel implements Car {

    private Long id;
    private String carModelName;
    private boolean airConditioning;
    private boolean spareTire;
    double feePerDay;
    private InsuranceModel insuranceModel;

    public CarModel(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay, InsuranceModel insuranceModel) {
        this.id = id;
        this.carModelName = carModelName;
        this.airConditioning = airConditioning;
        this.spareTire = spareTire;
        this.feePerDay = feePerDay;
        this.insuranceModel = insuranceModel;
    }

    @Override
    public void displayInformation() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Car ID: " + id)
                .append("\n")
                .append("Air conditioning: " + airConditioning)
                .append("\n")
                .append("Spare tire: " + spareTire)
                .append("\n")
                .append("Fee per day: " + feePerDay)
                .append("\n");

        System.out.println(stringBuilder);

    }

    @Override
    public double getPrice(int days, InsuranceModel insuranceModel) {

        double priceOfInsurance = insuranceModel.getPrice();
        double priceInTotal = priceOfInsurance + (days*feePerDay);

        return priceInTotal;
    }

    @Override
    public void rentCar(int days, InsuranceModel insuranceModel) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Car rented for " + days + "day(s)")
                .append("\n")
                .append("Total price =  " + getPrice(days, insuranceModel));

        System.out.println(stringBuilder);


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isSpareTire() {
        return spareTire;
    }

    public void setSpareTire(boolean spareTire) {
        this.spareTire = spareTire;
    }

    public double getFeePerDay() {
        return feePerDay;
    }

    public void setFeePerDay(double feePerDay) {
        this.feePerDay = feePerDay;
    }

    public InsuranceModel getInsuranceModel() {
        return insuranceModel;
    }

    public void setInsuranceModel(InsuranceModel insuranceModel) {
        this.insuranceModel = insuranceModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarModel carModel)) return false;
        return isAirConditioning() == carModel.isAirConditioning() && isSpareTire() == carModel.isSpareTire() && Double.compare(carModel.getFeePerDay(), getFeePerDay()) == 0 && getId().equals(carModel.getId()) && getCarModelName().equals(carModel.getCarModelName()) && getInsuranceModel().equals(carModel.getInsuranceModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCarModelName(), isAirConditioning(), isSpareTire(), getFeePerDay(), getInsuranceModel());
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", carModelName='" + carModelName + '\'' +
                ", airConditioning=" + airConditioning +
                ", spareTire=" + spareTire +
                ", feePerDay=" + feePerDay +
                ", insuranceModel=" + insuranceModel +
                '}';
    }
}

