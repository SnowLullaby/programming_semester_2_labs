package errors;

public class NoCommandError extends Exception {
    public NoCommandError() {
        super("Command don't exist");
    }
}
