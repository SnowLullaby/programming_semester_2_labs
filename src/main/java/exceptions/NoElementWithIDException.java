package exceptions;

public class NoElementWithIDException extends Exception{
    Long additionalInfo;
    public NoElementWithIDException(Long additionalInfo) {
        super("There is no elements with id " + additionalInfo.toString());
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo.toString();
    }
}
