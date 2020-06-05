package gangz.purchase.domain.request;

import framework.DomainEvent;

public class PurchaseRequestCreatedEvent extends DomainEvent {
    private final PurchaseRequest purchaseRequest;

    public PurchaseRequestCreatedEvent(PurchaseRequest purchaseRequest) {
        super();
        this.purchaseRequest = purchaseRequest;
    }
}
