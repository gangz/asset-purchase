package gangz.purchase.service;

import gangz.purchase.domain.asset.AssetTypeId;
import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.user.UserId;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
    @Override
    public PurchaseRequest getPurchaseRequest(UserId userId, AssetTypeId assetTypeId, int amount) {
        return PurchaseRequest.builder().creatorId(userId)
                .build().init()
                .addPurchaseItem(assetTypeId,amount);
    }
}
