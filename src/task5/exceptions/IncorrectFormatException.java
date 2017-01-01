package task5.exceptions;

import java.util.InputMismatchException;

public class IncorrectFormatException extends InputMismatchException {
    public IncorrectFormatException() { super(); }
    public IncorrectFormatException(String message) { super(message); }
}
