package pl.hetman.wiktoria.solvd.exceptions;

public class CarException extends CarRentalException {
    public CarException(String message) {
        super(message);
    }

    public CarException(String message, Throwable cause) {
        super(message, cause);
    }
}
