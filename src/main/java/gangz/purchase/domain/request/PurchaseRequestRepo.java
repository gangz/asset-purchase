package gangz.purchase.domain.request;

import gangz.purchase.domain.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRequestRepo extends JpaRepository<PurchaseRequest, PurchaseRequestId> {
    List<PurchaseRequest> findByCreatorId(UserId userId);
}
