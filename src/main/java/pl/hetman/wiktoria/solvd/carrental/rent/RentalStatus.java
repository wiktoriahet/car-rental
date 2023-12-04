package pl.hetman.wiktoria.solvd.carrental.rent;

public enum RentalStatus {

    AVAILABLE("Available"),
    NOT_AVAILABLE("Not available");

    static {
        System.out.printf("Checking rental status");
    }

    private final String status;

    RentalStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
