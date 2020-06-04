package gangz.purchase.domain.request;

import framework.Id;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRequest {
    private final Id requestId;
    List<RequestItem> items = new ArrayList<>();
    private PurchaseRequestStatus status;

    public PurchaseRequest(Requestor requestor) {
        this.requestId = requestor.getId();
        this.status = PurchaseRequestStatus.DRAFT;

    }

    public PurchaseRequest addPurchaseItem(Id assetTypeId, int amount) {
        this.items.add(new RequestItem(assetTypeId, amount));
        return this;
    }

    public PurchaseRequestStatus status() {
        return this.status;
    }
}
