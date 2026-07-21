package lk.sportsclub.platform.shared.exceptions;

public class InsufficientBalanceException extends DomainException{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
