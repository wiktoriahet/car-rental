package pl.hetman.wiktoria.solvd.insurance;

public enum InsuranceCatalogue {

    BASIC("Basic", 100),
    EXTRA("Extra", 200),
    DELUXE("Deluxe", 300);

    private String packageName;
    private double price;

    InsuranceCatalogue(String packageName, double price) {
        this.packageName = packageName;
        this.price = price;
    }

    public String getPackageName() {
        return packageName;
    }

    public double getPrice() {
        return price;
    }
}
