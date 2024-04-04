package exceptions;

public class NoParamsException extends Exception {
    String commandName;
    public NoParamsException(String command) {
        super("Not enough arguments for command '" + command + "'");
        this.commandName = command;
    }
}