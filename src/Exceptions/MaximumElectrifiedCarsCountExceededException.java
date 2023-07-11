package Exceptions;
public class MaximumElectrifiedCarsCountExceededException extends RuntimeException {
    public MaximumElectrifiedCarsCountExceededException(String message) {
        super(message);
    }
}