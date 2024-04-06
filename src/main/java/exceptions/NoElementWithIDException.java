package exceptions;

/**
 *  Exception for incorrect ID
 *  @author Ekaterina Vavilina
 */
public class NoElementWithIDException extends Exception{
    /** incorrect ID */
    Long additionalInfo;

    /** Exception constructor */
    public NoElementWithIDException(Long additionalInfo) {
        super("There is no elements with id " + additionalInfo.toString());
        this.additionalInfo = additionalInfo;
    }

    /** Getter for commandName */
    public String getAdditionalInfo() {
        return additionalInfo.toString();
    }
}
