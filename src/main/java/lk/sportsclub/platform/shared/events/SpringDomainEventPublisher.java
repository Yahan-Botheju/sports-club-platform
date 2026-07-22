package lk.sportsclub.platform.shared.events;

import org.springframework.context.ApplicationEventPublisher;

public class SpringDomainEventPublisher implements DomainEventPublisher{
    //inject required dependencies
    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(BaseDomainEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
