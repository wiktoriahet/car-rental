package pl.hetman.wiktoria.solvd.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;

class CarModelTest {

    static{
        System.setProperty("log4j.configurationFile","log4j2.xml");
    }

    @Test
    void displayInformation() {
        //given
        CarModel carModel = new SedanCar(UniqueIdGenerator.generateId(), SedanModel.PASSAT.getModel(), true, true, SedanModel.PASSAT.getPricePerDay(), true);

        //when
        boolean displayedInformation = carModel.displayInformation();

        //then
        //Assertions.assertEquals(true, displayedInformation);
        Assertions.assertTrue(displayedInformation, "Informations couldn't be displayed");


    }
}