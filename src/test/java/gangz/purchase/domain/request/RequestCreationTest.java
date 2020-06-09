package gangz.purchase.domain.request;

import gangz.purchase.api.data.StatusNotAllowedException;
import gangz.purchase.domain.asset.AssetTypeId;
import gangz.purchase.domain.user.UserId;
import gangz.purchase.service.PurchaseRequestService;
import gangz.purchase.service.PurchaseRequestServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestCreationTest {
    @DisplayName("创建一个采购请求，初始状态为DRAFT，且创建日期及创建人不为空")
    @Test
    void test_should_create_purchase_request_successfully(){
        PurchaseRequest request = createPurchaseRequest();
        assertEquals(PurchaseRequestStatus.DRAFT, request.status());
        assertNotNull(request.getCreatorId());
        assertNotNull(request.getCreatedDate());
    }

    @DisplayName("提交采购请求时，应该触发采购请求已提交事件")
    @Test
    void test_should_produce_request_committed_event(){
        PurchaseRequest request = createPurchaseRequest();
        request.commit();
        assertEquals(1,request.domainEvents().size());
    }

    @DisplayName("采购请求被提交后，就不允许被增删")
    @Test
    void test_should_not_allow_modify_after_committed(){
        PurchaseRequest request = createPurchaseRequest();
        request.commit();
        Assertions.assertThrows(StatusNotAllowedException.class,()->{
            request.addPurchaseItem(AssetTypeId.of(UUID.randomUUID()),1);
        });
    }

    @DisplayName("批准采购请求时，应该触发采购请求已批准事件")
    @Test
    void test_should_produce_request_approved_event(){
        PurchaseRequest request = createPurchaseRequest();
        request.approve();
        assertEquals(1,request.domainEvents().size());
    }

    @SneakyThrows
    private PurchaseRequest createPurchaseRequest() {
        UserId userId = UserId.of(UUID.randomUUID());
        AssetTypeId assetTypeId = AssetTypeId.of(UUID.randomUUID());
        int amount = 30;

        PurchaseRequestService service = new PurchaseRequestServiceImpl();
        PurchaseRequest request = service.createPurchaseRequest(userId);
        request.addPurchaseItem(assetTypeId,amount);
        return request;
    }
}
