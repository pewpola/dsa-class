package exceptions;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException(String errorMessage) {
        super(errorMessage);
    }
}
