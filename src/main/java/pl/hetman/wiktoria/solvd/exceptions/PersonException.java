package pl.hetman.wiktoria.solvd.exceptions;

public class PersonException extends Exception{
    public PersonException(String message) {
        super(message);
    }

    public PersonException(String message, Throwable cause) {
        super(message, cause);
    }
}
