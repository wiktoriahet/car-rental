package pl.hetman.wiktoria.solvd.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.person.Customer;
import pl.hetman.wiktoria.solvd.person.Profile;

public class ProfileThread implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(ProfileThread.class);

    private Profile profile;
    private Customer customer;

    public ProfileThread(Profile profile, Customer customer) {
        LOGGER.info("ProfileThread(" + profile + ", " + customer + ")");
        this.profile = profile;
        this.customer = customer;
        LOGGER.info("ProfileThread(...)");
    }

    @Override
    public void run() {

        try {
            LOGGER.info("run()");
            profile.createAProfile(customer);
            System.out.println("### Profile creation thread for " + customer.getName() + " " + customer.getSurname() + " ###");
            Thread.sleep(100);
            LOGGER.info("run(...)");
        } catch (PersonException | InterruptedException e) {
            LOGGER.error(e.getMessage());
        }

    }

}
