package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class CarModel implements ICar {

    private static final Logger LOGGER = LogManager.getLogger(CarModel.class);

    private Long id;
    private String carModelName;
    private boolean airConditioning;
    private boolean spareTire;
    double feePerDay;

    public CarModel(Long id, String carModelName, boolean airConditioning, boolean spareTire, double feePerDay) {
        LOGGER.info("CarModel("+id+", "+carModelName+", "+spareTire+", "+feePerDay+")");
        this.id = id;
        this.carModelName = carModelName;
        this.airConditioning = airConditioning;
        this.spareTire = spareTire;
        this.feePerDay = feePerDay;
        LOGGER.info("CarModel(...)");

    }

    @Override
    public boolean displayInformation() {
        LOGGER.info("Displaying information for Car");
        boolean informationDisplayed = true;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Car ID: " + id)
                .append("\n")
                .append("Air conditioning: " + airConditioning)
                .append("\n")
                .append("Spare tire: " + spareTire)
                .append("\n")
                .append("Fee per day: " + feePerDay);

        LOGGER.info(stringBuilder.toString());
        return informationDisplayed;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarModel carModel)) return false;
        return isAirConditioning() == carModel.isAirConditioning() && isSpareTire() == carModel.isSpareTire() && Double.compare(carModel.getFeePerDay(), getFeePerDay()) == 0 && getId().equals(carModel.getId()) && getCarModelName().equals(carModel.getCarModelName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCarModelName(), isAirConditioning(), isSpareTire(), getFeePerDay());
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", carModelName='" + carModelName + '\'' +
                ", airConditioning=" + airConditioning +
                ", spareTire=" + spareTire +
                ", feePerDay=" + feePerDay +
                '}';
    }
}

