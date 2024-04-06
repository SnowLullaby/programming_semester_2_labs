package exceptions;

/**
 *  Exception for undefined command
 *  @author Ekaterina Vavilina
 */
public class NoCommandException extends Exception {
    /** undefined command as string */
    String commandName;

    /** Exception constructor */
    public NoCommandException(String command) {
        super("Command '" + command + "' doesn't exist");
        this.commandName = command;
    }

    /** Getter for commandName */
    public String getAdditionalInfo() {
        return commandName;
    }
}
