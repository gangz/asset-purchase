package gangz.purchase.api.dto;

import framework.DomainEvent;
import framework.util.ObjectUtil;
import gangz.purchase.domain.request.PurchaseRequest;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class PurchaseRequestCommittedEvent extends BasePurchaseRequestEvent {

    public PurchaseRequestCommittedEvent(PurchaseRequest purchaseRequest) {
        super(purchaseRequest);
    }
}
