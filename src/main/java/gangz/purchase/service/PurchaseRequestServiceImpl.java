package gangz.purchase.service;

import gangz.purchase.api.data.StatusNotAllowedException;
import gangz.purchase.domain.asset.AssetTypeId;
import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.user.UserId;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
    @Override
    public PurchaseRequest createPurchaseRequest(UserId userId) {
        return PurchaseRequest.builder().creatorId(userId)
                .build().init();
    }

}
