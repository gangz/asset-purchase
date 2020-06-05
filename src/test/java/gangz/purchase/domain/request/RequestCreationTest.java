package gangz.purchase.domain.request;

import framework.Id;
import gangz.purchase.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestCreationTest {
    @Test
    void test_should_create_purchase_request_successfully(){
        PurchaseRequest request = createPurchaseRequest();
        assertEquals(PurchaseRequestStatus.DRAFT, request.status());
        assertNotNull(request.committerId());
        assertNotNull(request.committedDate());
    }

    @Test
    void test_should_produce_request_approved_event(){
        PurchaseRequest request = createPurchaseRequest();
        request.approve();
        assertEquals(1,request.domainEvents().size());
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
