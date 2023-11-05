package pl.hetman.wiktoria.solvd.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

import static org.junit.jupiter.api.Assertions.*;

class CarModelTest {

    @Test
    void displayInformation() {
        //given
        CarModel carModel = new SedanCar(UniqueIdGenerator.generateId(), "Ford", true, true, 600, true);

        //when
        boolean displayedInformation = carModel.displayInformation();

        //then
        Assertions.assertEquals(true, displayedInformation);

    }
}