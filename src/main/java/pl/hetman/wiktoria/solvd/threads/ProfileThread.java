package pl.hetman.wiktoria.solvd.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.person.Profile;

public class ProfileThread implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(ProfileThread.class);

    private Profile profile;

    public ProfileThread(Profile profile) {
        LOGGER.info("ProfileThread(" + profile + ")");
        this.profile = profile;
        LOGGER.info("ProfileThread(...)");
    }

    @Override
    public void run() {

        try {
            LOGGER.info("run()");
            profile.createAProfile(profile.getName(), profile.getSurname(), profile.getInsuranceModel(), profile.getCarModel());
            System.out.println("### Profile creation thread for " + profile.getName() + " " + profile.getSurname() + " ###");
            Thread.sleep(100);
            LOGGER.info("run(...)");
        } catch (PersonException | InterruptedException e) {
            LOGGER.error(e.getMessage());
        }

    }

}
