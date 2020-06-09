package gangz.purchase.api.data;

import gangz.purchase.domain.request.PurchaseRequest;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class PurchaseRequestApprovedEvent extends BasePurchaseRequestEvent {
    public PurchaseRequestApprovedEvent(PurchaseRequest purchaseRequest) {
        super(purchaseRequest);
    }
}
