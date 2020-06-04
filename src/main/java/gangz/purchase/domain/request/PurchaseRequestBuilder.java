package gangz.purchase.domain.request;

import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.Requestor;

public class PurchaseRequestBuilder {
    private final PurchaseRequest purchaseRequest  ;

    public PurchaseRequestBuilder(Requestor requestor) {
        this.purchaseRequest = new PurchaseRequest(requestor);
    }

    public PurchaseRequest build() {
        return this.purchaseRequest;
    }


}
