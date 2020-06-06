package gangz.purchase.domain.user;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private String name;
    @Id
    private UUID id;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return this.id;
    }
}
