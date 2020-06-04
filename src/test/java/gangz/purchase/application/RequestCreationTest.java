package gangz.purchase.application;

import framework.Id;
import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.PurchaseRequestStatus;
import gangz.purchase.domain.request.Requestor;
import gangz.purchase.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestCreationTest {
    @Test
    void test_should_create_purchase_request_successfully(){
        PurchaseRequest request = createPurchaseRequest();
        assertEquals(PurchaseRequestStatus.DRAFT, request.status());
    }

    private PurchaseRequest createPurchaseRequest() {
        Requestor requestor = new Requestor(new User("gangz"));
        PurchaseRequest purchaseRequest = requestor.buildPurchaseRequest()
                .build()
                .addPurchaseItem(Id.build(),30)
                ;
        return purchaseRequest;

    }
}
