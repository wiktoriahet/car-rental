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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Generics and collections task
public class CarRentalShop extends CarRentalOffer implements IShop {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalShop.class);

    private final String carRentalName = "Car Rental Service";

    //private Basket basket = new Basket();

    private void chooseOffer(){
        LOGGER.info("chooseOffer()");
        System.out.println("Choose offer");
        LOGGER.info("chooseOffer(...)");
    }
    private void chooseOffer(CarModel carModel, InsuranceModel insuranceModel){
        LOGGER.info("chooseOffer("+carModel+", "+insuranceModel+")");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Confirm chosen offer: ")
                .append("\n")
                .append("Car: " + carModel.getCarModelName())
                .append("\n")
                .append("Insurance: " + insuranceModel.getPackageName());

        System.out.println(stringBuilder);
        LOGGER.info("chooseOffer(...)");
    }

    @Override
    public Basket addToBasket(CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException {
        LOGGER.info("Adding car and insurance to the basket");
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
        Basket<Objects> basket = new Basket<>();
        Basket.insert(basket, carModel);
        Basket.insert(basket, insuranceModel);
        LOGGER.info("Car and insurance added to the basket: " + basket.toString());
        return basket;
    }

    @Override
    public boolean removeFromBasket(Basket<Objects> basket, CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException{
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
        Basket.deleteAtPosition(basket, 0);
        Basket.deleteAtPosition(basket, 0);
        LOGGER.info("Car and insurance deleted from the basket");
        return true;
    }

    @Override
    public boolean finishShopping(CarRentalModel carRentalModel)throws ShopException {
        LOGGER.info("finishShopping("+carRentalModel+")");
        boolean finishedShopping = false;
        if(carRentalModel==null){
            ShopException cannotRemoveFromBasket = new ShopException("Cannot remove from basket");
            FileLogger.logToFile(cannotRemoveFromBasket.getMessage());
            LOGGER.error(cannotRemoveFromBasket.getMessage());
            throw cannotRemoveFromBasket;
        }
        finishedShopping = true;
        System.out.println("You finished your purchase");
        LOGGER.info("finishShopping(...)");
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
