package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.person.Profile;
import pl.hetman.wiktoria.solvd.threads.ConnectionPool;
import pl.hetman.wiktoria.solvd.threads.DatabaseConnection;
import pl.hetman.wiktoria.solvd.threads.ProfileThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsMain {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) throws PersonException {

        BlockingQueue<DatabaseConnection> instance = ConnectionPool.getInstance();

        InsuranceModel insuranceModel = new InsuranceModel(UniqueIdGenerator.generateId(), "Insurance name enum", true, true, true, 100);
        CarModel carModel = new CarModel(UniqueIdGenerator.generateId(), "car model", true, true, 100);

        Profile profileAnnaNowak = new Profile("Anna", "Nowak", insuranceModel, carModel);
        Profile profileJanKowalski = new Profile("Jan", "Kowalski", insuranceModel, carModel);
        Profile profileAdamMickiewicz = new Profile("Adam", "Mickiewicz", insuranceModel, carModel);
        Profile profileJanKochanowski = new Profile("Jan", "Kochanowski", insuranceModel, carModel);
        Profile profileHarryPotter = new Profile("Harry", "Potter", insuranceModel, carModel);
        Profile profileHenrykSienkiewicz = new Profile("Henryk", "Sienkiewicz", insuranceModel, carModel);
        Profile profileMagdaGessler = new Profile("Magda", "Gessler", insuranceModel, carModel);

        ProfileThread profileAnnaNowakThread = new ProfileThread(profileAnnaNowak);
        ProfileThread profileJanKowalskiThread = new ProfileThread(profileJanKowalski);
        ProfileThread profileAdamMickiewiczThread = new ProfileThread(profileAdamMickiewicz);
        ProfileThread profileJanKochanowskiThread = new ProfileThread(profileJanKochanowski);
        ProfileThread profileHarryPotterThread = new ProfileThread(profileHarryPotter);
        ProfileThread profileHenrykSienkiewiczThread = new ProfileThread(profileHenrykSienkiewicz);
        ProfileThread profileMagdaGesslerThread = new ProfileThread(profileMagdaGessler);

        ExecutorService executorService = Executors.newFixedThreadPool(instance.size());
        executorService.execute(profileAnnaNowakThread);
        executorService.execute(profileJanKowalskiThread);
        executorService.execute(profileAdamMickiewiczThread);
        executorService.execute(profileJanKochanowskiThread);
        executorService.execute(profileHarryPotterThread);
        executorService.execute(profileHenrykSienkiewiczThread);
        executorService.execute(profileMagdaGesslerThread);

        executorService.shutdown();

        try {
            boolean termination = executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
    }
}
