package pl.hetman.wiktoria.solvd.carrental;

public enum ShoppingStatus {

    ONGOING("Ongoing"),
    FINISHED("Finished"),
    CANCELED("Canceled");

    private final String status;

    static {
        System.out.println("Checking shopping status");
    }

    ShoppingStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
