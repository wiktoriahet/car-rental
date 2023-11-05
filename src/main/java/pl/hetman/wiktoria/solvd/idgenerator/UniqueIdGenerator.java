package pl.hetman.wiktoria.solvd.idgenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.carrental.CarRentalShop;

import java.util.Random;

public class UniqueIdGenerator {
    private static final Logger LOGGER = LogManager.getLogger(UniqueIdGenerator.class);

    public static Long generateId(){
        LOGGER.always().log("generateId()");
        Random random = new Random();
        long id = random.nextLong(1_000_000L);
        LOGGER.always().log("generateId(...)");
        return id;
    }
}
