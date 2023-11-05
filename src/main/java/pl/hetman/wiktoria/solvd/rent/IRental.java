package pl.hetman.wiktoria.solvd.rent;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

import java.util.Optional;

public interface IRental{

    boolean rentACar(CarModel carModel, InsuranceModel insuranceModel)throws CarRentalException;
    double getPrice(CarModel carModel, InsuranceModel insuranceModel);
}
