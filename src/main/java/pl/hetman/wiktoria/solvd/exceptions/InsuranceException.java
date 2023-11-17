package pl.hetman.wiktoria.solvd.exceptions;

public class InsuranceException extends CarRentalException {
    public InsuranceException(String message) {
        super(message);
    }

    public InsuranceException(String message, Throwable cause) {
        super(message, cause);
    }
}
