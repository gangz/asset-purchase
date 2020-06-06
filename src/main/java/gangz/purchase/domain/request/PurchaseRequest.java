package gangz.purchase.domain.request;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import framework.AbstractAggregateRoot;

public class PurchaseRequest extends AbstractAggregateRoot {
    public UUID id;
    private UUID submitterId;
    private Long submittedDate;
    private Long approveDate;
    private PurchaseRequestStatus status;
    List<RequestItem> items = new ArrayList<>();

    public PurchaseRequest(){
        id = UUID.randomUUID();
        this.status = PurchaseRequestStatus.DRAFT;
        this.submittedDate = System.currentTimeMillis();
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

    public Long committedDate() {
        return this.submittedDate;
    }

    public PurchaseRequest submitterId(UUID id) {
        this.submitterId = id;
        return this;
    }

	public UUID getSubmitterId() {
		return this.submitterId;
	}

	public Long getSubmittedDate() {
		return this.submittedDate;
	}
}
