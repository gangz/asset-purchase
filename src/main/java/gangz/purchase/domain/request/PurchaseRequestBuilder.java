package gangz.purchase.domain.request;

public class PurchaseRequestBuilder {
    private PurchaseRequest purchaseRequest  ;

    public PurchaseRequestBuilder(){
        purchaseRequest = new PurchaseRequest();
    }

    public static PurchaseRequestBuilder buildPurchaseRequest() {
        return new PurchaseRequestBuilder();
    }

    public PurchaseRequest build() {
        return this.purchaseRequest;
    }


}
