package hu.model.exception;

/**
 * A custom exception class for representing a not found error.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructs a new NotFoundException without a specific error message.
     */
    public NotFoundException() {
    }

    /**
     * Constructs a new NotFoundException with the specified error message.
     *
     * @param message the error message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new NotFoundException with the specified error message and cause.
     *
     * @param message the error message
     * @param cause   the cause of the exception
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
