package pl.hetman.wiktoria.solvd.carrental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.SuvCar;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.logs.FileLogger;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalShopTest {

    static{
        System.setProperty("log4j.configurationFile","log4j2.xml");
    }

    @Test
    void addToBasket() {
        //given
        CarRentalShop carRentalShop = new CarRentalShop();
        CarModel carModel = new SuvCar(UniqueIdGenerator.generateId(), "ford", true, false, 300, true, true, true);
        InsuranceModel insuranceModel = new InsuranceModel(UniqueIdGenerator.generateId(), "Deluxe", true, true, true, 400);
        boolean addedToBasket = false;
        //when
        try{
            addedToBasket = carRentalShop.addToBasket(carModel, insuranceModel);
        }catch (CarRentalException e){
            FileLogger.logToFile(e.getMessage());
        }

        //then
        Assertions.assertEquals(true, addedToBasket);

    }
}