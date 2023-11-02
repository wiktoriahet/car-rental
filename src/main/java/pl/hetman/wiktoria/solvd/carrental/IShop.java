package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public interface IShop {

    void addToBasket(CarModel carModel, InsuranceModel insuranceModel);
    void removeFromBasket();
    void finishShopping();

}
