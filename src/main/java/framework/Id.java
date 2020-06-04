package framework;

import java.util.UUID;

public class Id {
    private String id;

    public Id(String id) {
        this.id = id;
    }

    public static Id build() {
        return new Id(UUID.randomUUID().toString());
    }

    public String getId(){
        return this.id;
    }
}
