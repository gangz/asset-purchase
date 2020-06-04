package gangz.purchase.domain.request;


import framework.Id;
import gangz.purchase.domain.user.User;

public class Requestor {
    private final User user;

    public Requestor(User user) {
        this.user = user;
    }

    public PurchaseRequestBuilder buildPurchaseRequest() {
        return new PurchaseRequestBuilder(this);
    }

    public Id getId() {
        return this.user.getId();
    }
}
