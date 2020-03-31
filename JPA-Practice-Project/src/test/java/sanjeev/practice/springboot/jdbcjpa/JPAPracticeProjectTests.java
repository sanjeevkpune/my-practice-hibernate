package sanjeev.practice.springboot.jdbcjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JPAPracticeProjectTests {

	@Autowired
	ApplicationContext ctx;
	
	//Test to check if context loads
	@Test
	void contextLoads() {
		assertNotNull(ctx);
	}

}
