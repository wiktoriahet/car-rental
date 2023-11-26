package pl.hetman.wiktoria.solvd.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.car.EconomyModel;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceCatalogue;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;

class CustomerTest {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void customer() throws PersonException {
        //given
        InsuranceModel insuranceModel = new InsuranceModel(InsuranceCatalogue.BASIC);
        CarModel carModel = new CarModel(UniqueIdGenerator.generateId(), EconomyModel.IBIZA.getModel(), true, true, EconomyModel.IBIZA.getPricePerDay());
        Customer customer = new Customer(UniqueIdGenerator.generateId(), "Anna", "Nowak", insuranceModel, carModel);

        //when
        Long id = customer.getId();

        //then
        Assertions.assertNotNull(id, "id is null");

    }
}