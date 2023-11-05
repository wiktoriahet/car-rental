package pl.hetman.wiktoria.solvd.rent;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public interface IRental {

    void rentACar(CarModel carModel, InsuranceModel insuranceModel)throws CarRentalException;
    double getPrice(CarModel carModel, InsuranceModel insuranceModel);
}
