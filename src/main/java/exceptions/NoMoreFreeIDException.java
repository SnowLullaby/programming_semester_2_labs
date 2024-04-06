package exceptions;

/**
 *  Exception for id > LONG.MAX
 *  @author Ekaterina Vavilina
 */
public class NoMoreFreeIDException extends Exception {
    /** Exception constructor */
    public NoMoreFreeIDException() {
        super("No more free indexes");
    }
}