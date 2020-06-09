package gangz.purchase.application;

import gangz.purchase.domain.asset.AssetTypeId;
import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.PurchaseRequestStatus;
import gangz.purchase.domain.user.UserId;
import gangz.purchase.service.PurchaseRequestService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class RequestCreationTest {
    @Autowired PurchaseRequestService requestService;
    private UserId creatorId;

    @DisplayName("创建一个采购请求，初始状态为DRAFT，且创建日期及创建人不为空")
    @Test
    void test_should_create_purchase_request_successfully(){
        PurchaseRequest request = createPurchaseRequest();
        assertEquals(PurchaseRequestStatus.DRAFT, request.status());
        assertNotNull(request.getCreatorId());
        assertNotNull(request.getCreatedDate());
        assertEquals(1, requestService.countOfRequestCreatedBy(creatorId));
        assertEquals(creatorId,requestService.getPurchaseRequest(request.getId()).get().getCreatorId());
    }

    @SneakyThrows
    private PurchaseRequest createPurchaseRequest() {
        creatorId = UserId.of(UUID.randomUUID());
        AssetTypeId assetTypeId = AssetTypeId.of(UUID.randomUUID());
        int amount = 30;
        PurchaseRequest request = requestService.createPurchaseRequest(creatorId);
        request.addPurchaseItem(assetTypeId,amount);
        return request;
    }
}
