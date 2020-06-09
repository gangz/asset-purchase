package gangz.purchase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gangz.purchase.service.PurchaseRequestService;

@RestController
@RequestMapping("api/v1/purchase")
public class PurchaseApiController {
	@Autowired
	PurchaseRequestService purchaseRequestService;
	
	@GetMapping(path="/welcome")
	public ResponseEntity<Object>  welcome(@RequestHeader HttpHeaders headers) {
		return ok("welcome to PurchaseRequestService!");
	}
	
	
}
