package gangz.purchase.domain.request;

import framework.Identifier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;
import java.util.UUID;

@Value
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
@Embeddable
public class PurchaseRequestId implements Identifier {
    private UUID uid;
    public static PurchaseRequestId create() {
        return PurchaseRequestId.of(UUID.randomUUID());
    }
}
