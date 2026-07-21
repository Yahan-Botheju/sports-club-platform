package lk.sportsclub.platform.shared.exceptions;

public class ResourceNotFoundException extends DomainException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
