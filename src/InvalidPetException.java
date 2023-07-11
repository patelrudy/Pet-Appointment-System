/**
 * This Class is an Exception class.
 * @author Rudreshbhai Patel
 * @version 1.2
 */
public class InvalidPetException extends RuntimeException {
    /**
     * A Constructor to print the exception message if the Pet is invalid.
     */
    public InvalidPetException() {
        super("Your pet is invalid.");
    }

    /**
     * A constructor to print the exception message if the pet is invalid.
     * @param s takes in a String type to print that that string.
     */
    public InvalidPetException(String s) {
        super(s);
    }
}
