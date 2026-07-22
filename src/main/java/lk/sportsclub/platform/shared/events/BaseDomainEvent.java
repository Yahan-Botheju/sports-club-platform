package lk.sportsclub.platform.shared.events;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseDomainEvent {
    private final LocalDateTime occurredOn;


    protected BaseDomainEvent() {
        this.occurredOn = LocalDateTime.now();
    }
}
