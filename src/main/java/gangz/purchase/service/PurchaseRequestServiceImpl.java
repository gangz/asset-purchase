package gangz.purchase.service;

import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.PurchaseRequestId;
import gangz.purchase.domain.request.PurchaseRequestRepo;
import gangz.purchase.domain.user.UserId;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {

    final
    PurchaseRequestRepo repo;

    public PurchaseRequestServiceImpl(PurchaseRequestRepo repo) {
        this.repo = repo;
    }

    @Override
    public PurchaseRequest createPurchaseRequest(UserId userId) {
        PurchaseRequest request = PurchaseRequest.builder().creatorId(userId)
                .build().init();
        repo.save(request);
        return request;
    }

    @Override
    public Optional<PurchaseRequest> getPurchaseRequest(PurchaseRequestId id) {
        return repo.findById(id);
    }

    @Override
    public int countOfRequestCreatedBy(UserId userId) {
        return repo.findByCreatorId(userId).size();
    }

    @Override
    @Transactional
    public void commit(PurchaseRequestId id) {
        Optional<PurchaseRequest> request = repo.findById(id);
        request.ifPresent(v -> {
                    v.commit();
                    repo.save(v);
                }
        );
    }

}
