package pl.hetman.wiktoria.solvd.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;

public class Profile {

    private static final Logger LOGGER = LogManager.getLogger(Profile.class);

    public Profile() {
    }

    public Customer createAProfile(Customer customer) throws PersonException {
        LOGGER.info("createAProfile(" + customer + ")");
        System.out.println("Created new profile of: " + customer.getName() + " " + customer.getSurname());
        LOGGER.info("createAProfile(...)");
        return new Customer(customer.getId(), customer.getName(), customer.getSurname(), customer.getInsuranceModel(), customer.getCarModel());
    }

    @Override
    public String toString() {
        return "Profile{}";
    }
}
