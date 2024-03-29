package exceptions;

public class NoParamsException extends Exception {
    public NoParamsException() {
        super("Not enough arguments");
    }
}