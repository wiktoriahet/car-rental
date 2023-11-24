package pl.hetman.wiktoria.solvd.car;

public enum SedanModel {

    PASSAT("Passat", 100),
    MONDEO("Mondeo", 200),
    TOLEDO("Toledo", 300);

    static {
        System.out.println("Checking available sedan cars models");
    }

    private final String model;
    private final double pricePerDay;

    SedanModel(String model, double pricePerDay) {
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
