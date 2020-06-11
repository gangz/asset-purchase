package gangz.purchase.api;

import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.PurchaseRequestId;
import gangz.purchase.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.notFound;
import org.springframework.web.bind.annotation.*;

import gangz.purchase.service.PurchaseRequestService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/services/requests")
public class PurchaseApiController {
	final
	PurchaseRequestService purchaseRequestService;

	@Autowired
	public PurchaseApiController(PurchaseRequestService purchaseRequestService) {
		this.purchaseRequestService = purchaseRequestService;
	}

	@GetMapping(path="/welcome")
	public ResponseEntity<Object>  welcome(@RequestHeader HttpHeaders headers) {
		return ok("welcome to PurchaseRequestService!");
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Object> createPurchaseRequest(
			@RequestParam(value="creatorId", required=true) String creatorId){
		return ok(purchaseRequestService.createPurchaseRequest(UserId.of(creatorId)));
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path="/{id}")
	public ResponseEntity<Object> retrievePurchaseRequest(
			@PathVariable(value="id", required=true) String id){
		Optional<PurchaseRequest> ret = purchaseRequestService.getPurchaseRequest(PurchaseRequestId.of(id));
		if (ret.isPresent()){
			return ok(ret.get());
		}
		return notFound().build();
	}
}
