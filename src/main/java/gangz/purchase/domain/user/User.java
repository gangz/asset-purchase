package gangz.purchase.domain.user;

import framework.Id;

public class User  {
    private String name;
    private Id id;

    public User(String name) {
        this.name = name;
        this.id = Id.build();
    }

    public String getName() {
        return name;
    }

    public Id getId() {
        return this.id;
    }
}
