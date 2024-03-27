package errors;

public class NoElementWithID extends Exception{
    public NoElementWithID() {
        super("There is no elements with this ID");
    }
}
