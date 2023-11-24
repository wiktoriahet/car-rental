package pl.hetman.wiktoria.solvd.car;

public enum EconomyModel {

    IBIZA("Ibiza", 200),
    ASTRA("Astra", 300),
    FOCUS("Focus", 250);

    static {
        System.out.println("Checking available economy cars models");
    }

    private final String model;
    private final double pricePerDay;

    EconomyModel(String model, double pricePerDay) {
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}
