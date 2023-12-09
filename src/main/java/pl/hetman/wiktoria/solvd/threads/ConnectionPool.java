package pl.hetman.wiktoria.solvd.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static BlockingQueue<DatabaseConnection> pool;
    private static int poolSize = 5;

    private ConnectionPool() {
    }

    public static synchronized BlockingQueue<DatabaseConnection> getInstance() {
        if (pool == null) {
            pool = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                pool.add(new DatabaseConnection());
            }
        }
        return pool;
    }
}
