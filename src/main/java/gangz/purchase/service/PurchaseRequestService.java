package gangz.purchase.service;

import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.PurchaseRequestId;
import gangz.purchase.domain.user.UserId;

import java.util.Optional;

public interface PurchaseRequestService {

    PurchaseRequest createPurchaseRequest(UserId userId) ;

    Optional<PurchaseRequest> getPurchaseRequest(PurchaseRequestId id);

    int countOfRequestCreatedBy(UserId userId);
}
