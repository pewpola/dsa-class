package exceptions;

public class FullQueueException extends RuntimeException {
    public FullQueueException(String error) {
        super(error);
    }
}
