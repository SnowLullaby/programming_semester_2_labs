package exceptions;

public class NoCommandException extends Exception {
    String commandName;
    public NoCommandException(String command) {
        super("Command '" + command + "' doesn't exist");
        this.commandName = command;
    }
    public String getAdditionalInfo() {
        return commandName;
    }
}
