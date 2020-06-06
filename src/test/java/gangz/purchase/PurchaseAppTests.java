package gangz.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gangz.purchase.domain.user.User;
import gangz.purchase.domain.user.UserRepository;

@SpringBootTest
class PurchaseAppTests {

	@Autowired UserRepository userRepo;
	@Test
	void contextLoads() {

	}

}
