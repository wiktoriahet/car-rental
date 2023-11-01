package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class CarRentalShop extends CarRentalOffer implements Shop{

    private final String carRentalName = "Car Rental Service";

    private void chooseOffer(){
        System.out.println("Choose offer");
    }
    private void chooseOffer(CarModel carModel, InsuranceModel insuranceModel){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Confirm chosen offer: ")
                .append("\n")
                .append("Car: " + carModel.getCarModelName())
                .append("\n")
                .append("Insurance: " + insuranceModel.getPackageName());

        System.out.println(stringBuilder);
    }


    @Override
    public void addToBasket(CarModel carModel, InsuranceModel insuranceModel) {
        chooseOffer();
        chooseOffer(carModel, insuranceModel);
    }

    @Override
    public void removeFromBasket() {

        System.out.println("Remove chosen offer from basket");

    }

    @Override
    public void finishShopping() {

        System.out.println("Finish your purchase");

    }

    public String getCarRentalName() {
        return carRentalName;
    }

    @Override
    public String toString() {
        return "CarRentalShop{" +
                "carRentalName='" + carRentalName + '\'' +
                '}';
    }
}
