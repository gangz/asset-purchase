package gangz.purchase.service;

import gangz.purchase.api.data.StatusNotAllowedException;
import gangz.purchase.domain.asset.AssetTypeId;
import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.user.UserId;

public interface PurchaseRequestService {

    PurchaseRequest createPurchaseRequest(UserId userId) ;
}
