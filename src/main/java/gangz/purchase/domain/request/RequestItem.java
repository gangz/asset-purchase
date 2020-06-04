package gangz.purchase.domain.request;

import framework.Id;

public class RequestItem {
    private final Id id;
    private final int amount;

    public RequestItem(Id id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
