package gangz.purchase.domain.user;

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
public class UserId implements Identifier {
    private String id;
}
