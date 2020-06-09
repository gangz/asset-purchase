package gangz.purchase.domain.request;

import framework.AbstractAggregateRoot;
import framework.AggreateRoot;
import framework.util.DateUtil;
import gangz.purchase.api.dto.PurchaseRequestCommittedEvent;
import gangz.purchase.domain.asset.AssetTypeId;
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
    private UserId creatorId;
    private Long createdDate;
    private Long approvedDate;
    private Long committedDate;
    private PurchaseRequestStatus status;
    @OneToMany
    @OrderBy("id asc") @Builder.Default
    List<RequestItem> items = new ArrayList<>();

    public PurchaseRequest init() {
        id = PurchaseRequestId.of(UUID.randomUUID());
        this.status = PurchaseRequestStatus.DRAFT;
        this.createdDate = DateUtil.now();
        return this;
    }



    public PurchaseRequest addPurchaseItem(AssetTypeId assetTypeId, int amount) {
        this.items.add(RequestItem.of(items.size(), assetTypeId, amount));
        return this;
    }

    public PurchaseRequestStatus status() {
        return this.status;
    }

    public void approve() {
        this.status = PurchaseRequestStatus.APPROVED;
        this.approvedDate = DateUtil.now();
        this.registerEvent(new PurchaseRequestCommittedEvent(this));
    }

    public void commit() {
        this.status = PurchaseRequestStatus.COMMITED;
        this.committedDate = DateUtil.now();
        this.registerEvent(new PurchaseRequestCommittedEvent(this));
    }
}
