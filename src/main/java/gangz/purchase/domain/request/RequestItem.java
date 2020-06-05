package gangz.purchase.domain.request;

import java.util.UUID;

public class RequestItem {
    private final UUID id;
    private final int amount;

    public RequestItem(UUID id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
