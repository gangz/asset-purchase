package framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractAggregateRoot extends org.springframework.data.domain.AbstractAggregateRoot implements AggreateRoot {
    public Collection<DomainEvent> retrieveDomainEvents() {
        return this.domainEvents();
    }

    public void clearEvents() {
        this.clearDomainEvents();
    }


}
