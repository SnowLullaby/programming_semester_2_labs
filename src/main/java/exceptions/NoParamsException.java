package exceptions;

/**
 *  Exception for incorrect number of argument
 *  @author Ekaterina Vavilina
 */
public class NoParamsException extends Exception {
    /** command with incorrect number of arguments */
    String commandName;

    /** Exception constructor */
    public NoParamsException(String command) {
        super("Not enough arguments for command '" + command + "'");
        this.commandName = command;
    }
}