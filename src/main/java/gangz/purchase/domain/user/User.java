package gangz.purchase.domain.user;

import java.util.UUID;

public class User {
    private String name;
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
