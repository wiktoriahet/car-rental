package pl.hetman.wiktoria.solvd;

import pl.hetman.wiktoria.solvd.car.CarModel;
import pl.hetman.wiktoria.solvd.carrental.Basket;
import pl.hetman.wiktoria.solvd.carrental.CarRentalShop;
import pl.hetman.wiktoria.solvd.exceptions.CarRentalException;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;
import pl.hetman.wiktoria.solvd.insurance.InsuranceModel;
import pl.hetman.wiktoria.solvd.person.Customer;
import pl.hetman.wiktoria.solvd.person.Profile;
import pl.hetman.wiktoria.solvd.threads.ConnectionPool;
import pl.hetman.wiktoria.solvd.threads.DatabaseConnection;
import pl.hetman.wiktoria.solvd.threads.ProfileThread;
import pl.hetman.wiktoria.solvd.threads.ShopThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsMain {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) {

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

        CarRentalShop carRentalShop = new CarRentalShop();

        ExecutorService executorService = Executors.newFixedThreadPool(instance.size());
        executorService.execute(profileAnnaNowakThread);
        executorService.execute(profileJanKowalskiThread);
        executorService.execute(profileAdamMickiewiczThread);
        executorService.execute(profileJanKochanowskiThread);
        executorService.execute(profileHarryPotterThread);
        executorService.execute(profileHenrykSienkiewiczThread);
        executorService.execute(profileMagdaGesslerThread);
        executorService.execute(new ShopThread(carRentalShop, carModel, insuranceModel));

        executorService.shutdown();

        try {
            boolean termination = executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Profile profile = new Profile();
        profile.setName("John");
        profile.setSurname("Smith");
        profile.setInsuranceModel(insuranceModel);
        profile.setCarModel(carModel);

        CompletableFuture<Profile> completableFutureProfile = CompletableFuture.supplyAsync(() -> {

            try {
                profile.createAProfile(profile.getName(), profile.getSurname(), profile.getInsuranceModel(), profile.getCarModel());
                System.out.println(profile);
                Thread.sleep(1000);
            } catch (InterruptedException | PersonException e) {
                e.printStackTrace();
            }
            return profile;
        });

        CarRentalShop carRentalShopSecond = new CarRentalShop();

        CompletableFuture<Basket> completableFutureShop = CompletableFuture.supplyAsync(() -> {

            Basket basket = new Basket();
            try {
                basket = carRentalShopSecond.addToBasket(carModel, insuranceModel);
                Thread.sleep(1000);
            } catch (InterruptedException | CarRentalException e) {
                e.printStackTrace();
            }
            return basket;
        });

    }
}
