package lk.sportsclub.platform.shared.exceptions;

public class SlotAlreadyBookedException extends DomainException{
    public SlotAlreadyBookedException(String message) {
        super(message);
    }
}
