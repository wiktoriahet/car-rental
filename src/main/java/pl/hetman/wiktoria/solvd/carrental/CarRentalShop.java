package pl.hetman.wiktoria.solvd.carrental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;
import pl.hetman.wiktoria.solvd.exceptions.CarException;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.exceptions.InsuranceException;
import pl.hetman.wiktoria.solvd.exceptions.ShopException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.logs.FileLogger;

import java.util.List;
import java.util.Objects;

//Generics and collections task
public class CarRentalShop extends CarRentalOffer implements IShop {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalShop.class);

    private final String carRentalName = "Car Rental Service";
    private String status;

    public CarRentalShop() {
    }

    public CarRentalShop(List<CarModel> existingCars, List<InsuranceModel> insurancePackages, String status) {
        super(existingCars, insurancePackages);
        this.status = status;
    }

    private void chooseOffer() {
        LOGGER.info("chooseOffer()");
        System.out.println("Choose offer");
        LOGGER.info("chooseOffer(...)");
    }

    private void chooseOffer(CarModel carModel, InsuranceModel insuranceModel) {
        LOGGER.info("chooseOffer(" + carModel + ", " + insuranceModel.getInsurancePackageName() + ")");
        if (status.equals("ONGOING")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append("Confirm chosen offer: ")
                    .append("\n")
                    .append("Car: " + carModel.getCarModelName())
                    .append("\n")
                    .append("Insurance: " + insuranceModel.getInsurancePackageName());

            System.out.println(stringBuilder);
        } else {
            LOGGER.warn("Incorrect order status. Please try again.");
        }
        LOGGER.info("chooseOffer(...)");
    }

    @Override
    public Basket addToBasket(CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException {
        LOGGER.info("addToBasket()");
        LOGGER.info("Adding car and insurance to the basket");
        Basket<Objects> basket = new Basket<>();
        if (status.equals("ONGOING")) {
            if (carModel == null) {
                CarException carException = new CarException("Problem with car while adding to basket" + "\n");
                FileLogger.logToFile(carException.getMessage());
                LOGGER.error(carException.getMessage());
                throw carException;
            } else if (insuranceModel == null) {
                InsuranceException insuranceException = new InsuranceException("Problem with insurance while adding to basket" + "\n");
                FileLogger.logToFile(insuranceException.getMessage());
                LOGGER.error(insuranceException.getMessage());
                throw insuranceException;
            }
            Basket.insert(basket, carModel);
            Basket.insert(basket, insuranceModel);
            Basket.printList(basket);
            LOGGER.info("Car and insurance added to the basket");
        } else {
            LOGGER.warn("Incorrect order status. Please try again.");
        }
        LOGGER.info("addToBasket(...)");
        return basket;
    }

    @Override
    public boolean removeFromBasket(Basket<Objects> basket, CarModel carModel, InsuranceModel insuranceModel) throws CarRentalException {
        LOGGER.info("removeFromBasket()");
        if (status.equals("Ongoing")) {
            if (carModel == null) {
                CarException carException = new CarException("Problem with car while adding to basket" + "\n");
                FileLogger.logToFile(carException.getMessage());
                LOGGER.error(carException.getMessage());
                throw carException;
            } else if (insuranceModel == null) {
                InsuranceException insuranceException = new InsuranceException("Problem with insurance while adding to basket" + "\n");
                FileLogger.logToFile(insuranceException.getMessage());
                LOGGER.error(insuranceException.getMessage());
                throw insuranceException;
            }
            Basket.deleteAtPosition(basket, 0);
            Basket.deleteAtPosition(basket, 0);
            setStatus(ShoppingStatus.CANCELED.getStatus());
            LOGGER.info("Car and insurance deleted from the basket");
        } else {
            LOGGER.warn("Incorrect order status. Please try again.");
            return false;
        }
        LOGGER.info("removeFromBasket(...)");
        return true;
    }

    @Override
    public boolean finishShopping(CarRentalModel carRentalModel) throws ShopException {
        LOGGER.info("finishShopping(" + carRentalModel + ")");
            boolean finishedShopping = false;
        if (status.equals("Ongoing")) {
            if (carRentalModel == null) {
                ShopException cannotRemoveFromBasket = new ShopException("Cannot remove from basket");
                FileLogger.logToFile(cannotRemoveFromBasket.getMessage());
                LOGGER.error(cannotRemoveFromBasket.getMessage());
                throw cannotRemoveFromBasket;
            }
            finishedShopping = true;
            setStatus(ShoppingStatus.FINISHED.getStatus());
            System.out.println("You finished your purchase");
        }else{
            LOGGER.warn("Incorrect order status. Please try again.");
            return finishedShopping;
        }
        LOGGER.info("finishShopping(...)");
        return finishedShopping;

    }

    public String getCarRentalName() {
        return carRentalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "CarRentalShop{" +
                "carRentalName='" + carRentalName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
