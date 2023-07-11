package Exceptions;

public class MailboxCapacityExceededException extends RuntimeException {
    public MailboxCapacityExceededException(String message) {
        super(message);
    }
}