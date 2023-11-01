package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class CarRentalShop extends CarRentalOffer{

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


}
