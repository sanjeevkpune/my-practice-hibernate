package sanjeev.practice.hibernate.ch01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext ctx;
	@Test
	void contextLoads() {
		assertNotNull(ctx);
	}

}
