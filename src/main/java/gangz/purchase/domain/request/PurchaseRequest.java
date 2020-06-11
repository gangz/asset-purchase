package gangz.purchase.domain.request;

import framework.AbstractAggregateRoot;
import framework.util.DateUtil;
import gangz.purchase.api.data.PurchaseRequestCommittedEvent;
import gangz.purchase.api.data.StatusNotAllowedException;
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

/**
 * 采购请求
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest extends AbstractAggregateRoot {
    @EmbeddedId
    public PurchaseRequestId id;
    private UserId creatorId;
    private Long createdDate;
    private Long approvedDate;
    private Long committedDate;
    private PurchaseRequestStatus status;
    @OneToMany
    @OrderBy("itemId asc") @Builder.Default
    List<RequestItem> items = new ArrayList<>();

    /**
     * 创建一个采购请求
     * @return
     */
    public PurchaseRequest init() {
        id = PurchaseRequestId.of(UUID.randomUUID().toString());
        this.status = PurchaseRequestStatus.DRAFT;
        this.createdDate = DateUtil.now();
        return this;
    }

    /**
     * 向采购请求中增加一个采购项目
     * @param assetTypeId
     * @param amount
     * @return
     */
    public PurchaseRequest addPurchaseItem(AssetTypeId assetTypeId, int amount) throws StatusNotAllowedException {
        if (!this.status.equals(PurchaseRequestStatus.DRAFT))
            throw new StatusNotAllowedException();

        this.items.add(RequestItem.of(items.size(), assetTypeId, null,null,amount));
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
