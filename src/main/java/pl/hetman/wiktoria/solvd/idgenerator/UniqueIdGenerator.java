package pl.hetman.wiktoria.solvd.idgenerator;

import java.util.Random;
import java.util.logging.Logger;

public class UniqueIdGenerator {

    public static Long generateId(){
        Random random = new Random();
        long id = random.nextLong(1_000_000L);
        return id;
    }
}
