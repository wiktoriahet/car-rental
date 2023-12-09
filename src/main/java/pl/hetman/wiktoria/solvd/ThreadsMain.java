package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.person.Customer;
import pl.hetman.wiktoria.solvd.person.Profile;
import pl.hetman.wiktoria.solvd.threads.ConnectionPool;
import pl.hetman.wiktoria.solvd.threads.DatabaseConnection;
import pl.hetman.wiktoria.solvd.threads.ProfileThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsMain {

    public static void main(String[] args) throws PersonException {

        BlockingQueue<DatabaseConnection> instance = ConnectionPool.getInstance();

        Profile profile = new Profile();
        InsuranceModel insuranceModel = new InsuranceModel(UniqueIdGenerator.generateId(), "Insurance name enum", true, true, true, 100);
        CarModel carModel = new CarModel(UniqueIdGenerator.generateId(), "car model", true, true, 100);
        Customer customerAnnaNowak = new Customer(UniqueIdGenerator.generateId(), "Anna", "Nowak", insuranceModel, carModel);
        Customer customerJanKowalski = new Customer(UniqueIdGenerator.generateId(), "Jan", "Kowalski", insuranceModel, carModel);
        Customer customerAdamMickiewicz = new Customer(UniqueIdGenerator.generateId(), "Jan", "Kowalski", insuranceModel, carModel);
        Customer customerJanKochanowski = new Customer(UniqueIdGenerator.generateId(), "Jan", "Kochanowski", insuranceModel, carModel);
        Customer customerHarryPotter = new Customer(UniqueIdGenerator.generateId(), "Harry", "Potter", insuranceModel, carModel);
        Customer customerHenrykSienkiewicz = new Customer(UniqueIdGenerator.generateId(), "Henryk", "Sienkiewicz", insuranceModel, carModel);
        Customer customerMagdaGessler = new Customer(UniqueIdGenerator.generateId(), "Magda", "Gessler", insuranceModel, carModel);

        ProfileThread profileAnnaNowak = new ProfileThread(profile, customerAnnaNowak);
        ProfileThread profileJanKowalski = new ProfileThread(profile, customerJanKowalski);
        ProfileThread profileAdamMickiewicz = new ProfileThread(profile, customerAdamMickiewicz);
        ProfileThread profileJanKochanowski = new ProfileThread(profile, customerJanKochanowski);
        ProfileThread profileHarryPotter = new ProfileThread(profile, customerHarryPotter);
        ProfileThread profileHenrykSienkiewicz = new ProfileThread(profile, customerHenrykSienkiewicz);
        ProfileThread profileMagdaGessler = new ProfileThread(profile, customerMagdaGessler);

        ExecutorService executorService = Executors.newFixedThreadPool(instance.size());
        executorService.execute(profileAnnaNowak);
        executorService.execute(profileJanKowalski);
        executorService.execute(profileAdamMickiewicz);
        executorService.execute(profileJanKochanowski);
        executorService.execute(profileHarryPotter);
        executorService.execute(profileHenrykSienkiewicz);
        executorService.execute(profileMagdaGessler);

        executorService.shutdown();
        try {
            boolean termination = executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
