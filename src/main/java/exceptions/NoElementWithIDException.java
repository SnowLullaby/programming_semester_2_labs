package exceptions;

public class NoElementWithIDException extends Exception{
    public NoElementWithIDException() {
        super("There is no elements with this ID");
    }
}
