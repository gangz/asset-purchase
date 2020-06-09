package gangz.purchase.domain.request;

import framework.ValueObject;
import gangz.purchase.domain.asset.AssetTypeId;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Value
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
public class RequestItem implements ValueObject {
    @Id int itemId;
    AssetTypeId assetTypeId;
    Double unitPrice; //注意，货币的单位不应该是Double，此处仅为示例
    Double totalPrice;
    int amount;
}
