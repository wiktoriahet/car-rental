package pl.hetman.wiktoria.solvd.exceptions;

public class DepartmentException extends Exception{
    public DepartmentException(String message) {
        super(message);
    }

    public DepartmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
