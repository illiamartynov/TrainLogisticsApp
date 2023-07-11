package Exceptions;

public class MaximumWeightCapacityExceededException extends RuntimeException {
    public MaximumWeightCapacityExceededException(String message) {
        super(message);
    }
}