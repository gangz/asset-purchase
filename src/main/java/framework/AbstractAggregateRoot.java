package framework;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAggregateRoot {
    List<DomainEvent> events;
    public AbstractAggregateRoot(){
        events = new ArrayList<>();
    }
    public void registerEvent(DomainEvent event){
        events.add(event);
    }
    public List<DomainEvent> domainEvents() {
        return events;
    }

    public void clearEvents() {
        events.clear();
    }


}
