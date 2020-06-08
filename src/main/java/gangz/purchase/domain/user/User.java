package gangz.purchase.domain.user;

import framework.AbstractAggregateRoot;
import framework.AggreateRoot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractAggregateRoot implements AggreateRoot {
    @EmbeddedId
    private UserId id;
    private String name;

    public String getName() {
        return name;
    }

}
