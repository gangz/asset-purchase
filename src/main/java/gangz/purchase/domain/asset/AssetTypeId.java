package gangz.purchase.domain.asset;

import framework.Identifier;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;
import java.util.UUID;

@Value
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
@Embeddable
public class AssetTypeId implements Identifier {
    private UUID id;
    public static AssetTypeId create() {
        return AssetTypeId.of(UUID.randomUUID());
    }
}
