package pl.hetman.wiktoria.solvd.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.carrental.Basket;
import pl.hetman.wiktoria.solvd.carrental.CarRentalShop;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

public class ShopThread extends Thread {

    private static final Logger LOGGER = LogManager.getLogger(ShopThread.class);

    private CarRentalShop carRentalShop;
    private CarModel carModel;
    private InsuranceModel insuranceModel;

    public ShopThread(CarRentalShop carRentalShop, CarModel carModel, InsuranceModel insuranceModel) {
        LOGGER.info("ShopThread(" + carRentalShop.getCarRentalName() + ", " + carModel + ", " + insuranceModel + ")");
        this.carRentalShop = carRentalShop;
        this.carModel = carModel;
        this.insuranceModel = insuranceModel;
        LOGGER.info("ShopThread(...)");
    }

    @Override
    public void run() {
        try {
            LOGGER.info("run()");
            Basket basket = carRentalShop.addToBasket(carModel, insuranceModel);
            Thread.sleep(100);
            LOGGER.info("run(...)");
        } catch (CarRentalException | InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
