package pl.hetman.wiktoria.solvd.exceptions;

public class ShopException extends CarRentalException {
    public ShopException(String message) {
        super(message);
    }

    public ShopException(String message, Throwable cause) {
        super(message, cause);
    }
}
