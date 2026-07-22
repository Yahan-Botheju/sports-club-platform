package lk.sportsclub.platform.shared.events;

public interface DomainEventPublisher {
    void publish(BaseDomainEvent event);
}
