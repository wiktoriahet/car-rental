package pl.hetman.wiktoria.solvd.carrental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

import java.util.List;

//Generics and collections task
public class CarRentalOffer implements IOffer {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalOffer.class);

    private List<CarModel> existingCars;
    private List<InsuranceModel> insurancePackages;

    public CarRentalOffer() {
    }

    public CarRentalOffer(List<CarModel> existingCars, List<InsuranceModel> insurancePackages) {
        LOGGER.info("CarRentalOffer()");
        this.existingCars = existingCars;
        this.insurancePackages = insurancePackages;
        LOGGER.info("CarRentalOffer(...)");
    }

    @Override
    public final void printOffer() {
        LOGGER.info("printOffer()");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Cars available: " + existingCars)
                .append("\n")
                .append("Insurance packages available: " + insurancePackages);

        System.out.println(stringBuilder);
        LOGGER.info("printOffer(...)");
    }

    public List<CarModel> getExistingCars() {
        return existingCars;
    }

    public void setExistingCars(List<CarModel> existingCars) {
        this.existingCars = existingCars;
    }

    public List<InsuranceModel> getInsurancePackages() {
        return insurancePackages;
    }

    public void setInsurancePackages(List<InsuranceModel> insurancePackages) {
        this.insurancePackages = insurancePackages;
    }

    @Override
    public String toString() {
        return "CarRentalOffer{" +
                "existingCars=" + existingCars +
                ", insurancePackages=" + insurancePackages +
                '}';
    }
}
