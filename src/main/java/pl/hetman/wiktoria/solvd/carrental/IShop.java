package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.exceptions.ShopException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

import java.util.Objects;

public interface IShop {

    Basket addToBasket(CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException;

    boolean removeFromBasket(Basket<Objects> basket, CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException;

    boolean finishShopping(CarRentalModel carRentalModel) throws ShopException;

}
