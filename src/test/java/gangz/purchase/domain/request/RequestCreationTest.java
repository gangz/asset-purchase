package gangz.purchase.domain.request;

import gangz.purchase.domain.user.User;
import gangz.purchase.domain.user.UserId;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestCreationTest {
    @Test
    void test_should_create_purchase_request_successfully(){
        PurchaseRequest request = createPurchaseRequest();
        assertEquals(PurchaseRequestStatus.DRAFT, request.status());
        assertNotNull(request.getCommitterId());
        assertNotNull(request.getCommittedDate());
    }

    @Test
    void test_should_produce_request_approved_event(){
        PurchaseRequest request = createPurchaseRequest();
        request.approve();
        assertEquals(1,request.domainEvents().size());
    }

    private PurchaseRequest createPurchaseRequest() {
        return PurchaseRequest.builder().committerId(
                User.builder().id(UserId.of(UUID.randomUUID())).build().getId())
                .build().init()
                .addPurchaseItem(UUID.randomUUID(),30);

    }

}
