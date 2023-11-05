package pl.hetman.wiktoria.solvd.carrental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.CarException;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.exceptions.InsuranceException;
import pl.hetman.wiktoria.solvd.exceptions.ShopException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.logs.FileLogger;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;

public class CarRentalShop extends CarRentalOffer implements IShop {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalShop.class);

    private final String carRentalName = "Car Rental Service";

    private void chooseOffer(){
        LOGGER.always().log("chooseOffer()");
        System.out.println("Choose offer");
        LOGGER.always().log("chooseOffer(...)");
    }
    private void chooseOffer(CarModel carModel, InsuranceModel insuranceModel){
        LOGGER.always().log("chooseOffer("+carModel+", "+insuranceModel+")");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Confirm chosen offer: ")
                .append("\n")
                .append("Car: " + carModel.getCarModelName())
                .append("\n")
                .append("Insurance: " + insuranceModel.getPackageName());

        System.out.println(stringBuilder);
        LOGGER.always().log("chooseOffer(...)");
    }


    @Override
    public boolean addToBasket(CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException {
        LOGGER.always().log("addToBasket("+carModel+", "+insuranceModel+")");
        chooseOffer();
        boolean addedToBasket = false;
        if(carModel==null){
            CarException carException = new CarException("Problem with car while adding to basket" + "\n");
            FileLogger.logToFile(carException.getMessage());
            LOGGER.error(carException.getMessage());
            throw carException;
        } else if(insuranceModel==null){
            InsuranceException insuranceException = new InsuranceException("Problem with insurance while adding to basket" + "\n");
            FileLogger.logToFile(insuranceException.getMessage());
            LOGGER.error(insuranceException.getMessage());
            throw insuranceException;
        }
        chooseOffer(carModel, insuranceModel);
        addedToBasket=true;
        LOGGER.always().log("addToBasket(...)");
        return addedToBasket;
    }

    @Override
    public boolean removeFromBasket(CarModel carModel, InsuranceModel insuranceModel)throws CarRentalException{
        LOGGER.always().log("removeFromBasket("+carModel+", "+insuranceModel+")");
        boolean removedFromBasket = false;
        if(carModel==null||insuranceModel==null){
            ShopException cannotRemoveFromBasket = new ShopException("Cannot remove from basket");
            FileLogger.logToFile(cannotRemoveFromBasket.getMessage());
            LOGGER.error(cannotRemoveFromBasket.getMessage());
            throw cannotRemoveFromBasket;
        }
        removedFromBasket = true;
        System.out.println("Removed chosen offer from basket");
        LOGGER.always().log("removeFromBasket(...)");
        return removedFromBasket;

    }

    @Override
    public boolean finishShopping(CarRentalModel carRentalModel)throws ShopException {
        LOGGER.always().log("finishShopping("+carRentalModel+")");
        boolean finishedShopping = false;
        if(carRentalModel==null){
            ShopException cannotRemoveFromBasket = new ShopException("Cannot remove from basket");
            FileLogger.logToFile(cannotRemoveFromBasket.getMessage());
            LOGGER.error(cannotRemoveFromBasket.getMessage());
            throw cannotRemoveFromBasket;
        }
        finishedShopping = true;
        System.out.println("You finished your purchase");
        LOGGER.always().log("finishShopping(...)");
        return finishedShopping;

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
