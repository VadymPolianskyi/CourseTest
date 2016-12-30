package task5.exceptions;

import java.util.InputMismatchException;

/**
 * Created by vadym on 30.12.16.
 */
public class IncorrectFormatException extends InputMismatchException {
    public IncorrectFormatException() { super(); }
    public IncorrectFormatException(String message) { super(message); }
}
