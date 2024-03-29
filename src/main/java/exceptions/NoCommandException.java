package exceptions;

public class NoCommandException extends Exception {
    public NoCommandException() {
        super("Command doesn't exist");
    }
}
