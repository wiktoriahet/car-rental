package pl.hetman.wiktoria.solvd.exceptions;

public class CarRentalException extends Exception {
    public CarRentalException(String message) {
        super(message);
    }

    public CarRentalException(String message, Throwable cause) {
        super(message, cause);
    }
}
