package gangz.purchase.application;

import gangz.purchase.api.data.PurchaseRequestCommittedEvent;
import org.springframework.transaction.event.TransactionalEventListener;

public interface EventListener {
    @TransactionalEventListener
    public void handleEvent(PurchaseRequestCommittedEvent event);
}
