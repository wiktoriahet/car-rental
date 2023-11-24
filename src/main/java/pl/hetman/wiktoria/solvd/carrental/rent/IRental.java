package pl.hetman.wiktoria.solvd.carrental.rent;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public interface IRental{

    boolean rentACar(CarModel carModel, InsuranceModel insuranceModel)throws CarRentalException;
    double getRentalPrice(CarModel carModel, InsuranceModel insuranceModel);
}
