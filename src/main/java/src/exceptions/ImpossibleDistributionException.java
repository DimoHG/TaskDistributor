package src.exceptions;

public class ImpossibleDistributionException extends RuntimeException{
    public ImpossibleDistributionException() {
        super("The tasks can not be distributed without overlapping");
    }
}
