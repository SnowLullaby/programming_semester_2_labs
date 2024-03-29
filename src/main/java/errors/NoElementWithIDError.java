package errors;

public class NoElementWithIDError extends Exception{
    public NoElementWithIDError() {
        super("There is no elements with this ID");
    }
}
