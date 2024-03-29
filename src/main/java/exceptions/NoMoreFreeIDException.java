package exceptions;

public class NoMoreFreeIDException extends Exception {
    public NoMoreFreeIDException() {
        super("No more free indexes");
    }
}