package pl.hetman.wiktoria.solvd.car;

public enum SuvModel {

    TOUAREG("Touareg", 200),
    FREEMONT("Freemont", 300),
    CAYENNE("Cayenne", 400);

    static {
        System.out.println("Checking available suv cars models");
    }

    private final String model;
    private final double pricePerDay;

    SuvModel(String model, double pricePerDay) {
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
