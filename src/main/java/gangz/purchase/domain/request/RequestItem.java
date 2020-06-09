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
    @Id int id;
    AssetTypeId assetTypeId;
    int amount;
}
