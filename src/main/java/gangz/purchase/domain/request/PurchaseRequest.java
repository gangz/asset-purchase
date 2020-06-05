package gangz.purchase.domain.request;

import framework.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseRequest extends AbstractAggregateRoot {
    public UUID id;
    private UUID committerId;
    private Long committedDate;
    private Long approveDate;
    private PurchaseRequestStatus status;
    List<RequestItem> items = new ArrayList<>();

    public PurchaseRequest(){
        id = UUID.randomUUID();
        this.status = PurchaseRequestStatus.DRAFT;
        this.committedDate = System.currentTimeMillis();
    }

    public PurchaseRequest addPurchaseItem(UUID assetTypeId, int amount) {
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


    public UUID committerId() {
        return this.committerId;
    }

    public Long committedDate() {
        return this.committedDate;
    }

    public PurchaseRequest committerId(UUID id) {
        this.committerId = id;
        return this;
    }
}
