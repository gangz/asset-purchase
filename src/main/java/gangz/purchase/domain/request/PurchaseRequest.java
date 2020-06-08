package gangz.purchase.domain.request;

import framework.AbstractAggregateRoot;
import framework.AggreateRoot;
import gangz.purchase.api.dto.PurchaseRequestCreatedEvent;
import gangz.purchase.domain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest extends AbstractAggregateRoot implements AggreateRoot {
    @EmbeddedId
    public PurchaseRequestId id;
    private UserId committerId;
    private Long committedDate;
    private Long approvedDate;
    private PurchaseRequestStatus status;
    @OneToMany
    @OrderBy("id asc") @Builder.Default
    List<RequestItem> items = new ArrayList<>();

    public PurchaseRequest init() {
        id = PurchaseRequestId.of(UUID.randomUUID());
        this.status = PurchaseRequestStatus.DRAFT;
        this.committedDate = System.currentTimeMillis();
        return this;
    }

    public PurchaseRequest addPurchaseItem(UUID assetTypeId, int amount) {
        this.items.add(RequestItem.of(items.size(), assetTypeId, amount));
        return this;
    }

    public PurchaseRequestStatus status() {
        return this.status;
    }

    public void approve() {
        this.status = PurchaseRequestStatus.APPROVED;
        this.approvedDate = System.currentTimeMillis();
        this.registerEvent(new PurchaseRequestCreatedEvent(this));
    }
}
