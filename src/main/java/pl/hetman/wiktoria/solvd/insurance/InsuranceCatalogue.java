package pl.hetman.wiktoria.solvd.insurance;

public enum InsuranceCatalogue {

    BASIC("Basic", 100),
    EXTRA("Extra", 200),
    DELUXE("Deluxe", 300);

    private final String packageName;
    private final double price;

    static {
        System.out.printf("Loading insurance catalogue");
    }

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

    @Override
    public String toString() {
        return "InsuranceCatalogue{" +
                "packageName='" + packageName + '\'' +
                ", price=" + price +
                '}';
    }
}
