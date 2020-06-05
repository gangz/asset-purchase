package gangz.purchase.domain.request;

import framework.AbstractAggregateRoot;
import framework.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseRequest extends AbstractAggregateRoot {
    private final Id id;
    private final Id committerId;
    private Long committedDate;
    private long approveDate;
    private PurchaseRequestStatus status;
    List<RequestItem> items = new ArrayList<>();

    public PurchaseRequest(Requestor requestor) {
        id = Id.build();
        this.committerId = requestor.getId();
        this.status = PurchaseRequestStatus.DRAFT;
        this.committedDate = System.currentTimeMillis();
    }

    public PurchaseRequest addPurchaseItem(Id assetTypeId, int amount) {
        this.items.add(new RequestItem(assetTypeId, amount));
        return this;
    }

    public PurchaseRequestStatus status() {
        return this.status;
    }

    public void approve() {
        this.status = PurchaseRequestStatus.APPROVED;
        this.approveDate = System.currentTimeMillis();
        this.registerEvent(new PurchaseRequestCreatedEvent(this));
    }


    public Id committerId() {
        return this.committerId;
    }

    public Long committedDate() {
        return this.committedDate;
    }
}
