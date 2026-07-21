package lk.sportsclub.platform.shared.exceptions;

public class DomainException  extends RuntimeException{
    public DomainException(String message){
        super(message);
    }
}
