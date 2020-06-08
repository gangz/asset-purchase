package gangz.purchase.domain.request;

import framework.ValueObject;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Value
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
public class RequestItem implements ValueObject {
    @Id int id;
    UUID deviceId;
    int amount;
}
