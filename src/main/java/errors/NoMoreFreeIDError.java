package errors;

public class NoMoreFreeIDError extends Exception {
    public NoMoreFreeIDError() {
        super("No more free indexes");
    }
}