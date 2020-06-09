package gangz.purchase.api.data;

import framework.DomainEvent;
import framework.util.ObjectUtil;
import gangz.purchase.domain.request.PurchaseRequest;

public abstract  class BasePurchaseRequestEvent implements DomainEvent {
    PurchaseRequestDTO purchaseRequest;
    public BasePurchaseRequestEvent(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = new PurchaseRequestDTO();
        ObjectUtil.copyProperties(this.purchaseRequest, purchaseRequest);
    }
}
