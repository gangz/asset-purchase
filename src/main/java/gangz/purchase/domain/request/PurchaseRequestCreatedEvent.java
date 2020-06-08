package gangz.purchase.domain.request;

import framework.DomainEvent;
import framework.util.ObjectUtil;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class PurchaseRequestCreatedEvent implements DomainEvent {
    PurchaseRequestDTO purchaseRequest;

    public PurchaseRequestCreatedEvent(PurchaseRequest purchaseRequest) {
        super();
        this.purchaseRequest = new PurchaseRequestDTO();
        ObjectUtil.copyProperties(this.purchaseRequest, purchaseRequest);
    }
}
