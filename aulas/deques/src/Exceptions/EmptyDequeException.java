package Exceptions;

public class EmptyDequeException extends RuntimeException {
    public EmptyDequeException(String error) {
        super(error);
    }
}