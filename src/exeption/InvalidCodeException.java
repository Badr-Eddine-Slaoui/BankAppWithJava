package exeption;

public class InvalidCodeException extends RuntimeException {
    public InvalidCodeException(String message) {
        super(message);
    }
}
