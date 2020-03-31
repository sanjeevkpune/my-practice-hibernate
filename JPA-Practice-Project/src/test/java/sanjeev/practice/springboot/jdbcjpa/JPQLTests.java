package sanjeev.practice.springboot.jdbcjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sanjeev.practice.springboot.jdbcjpa.entities.Course;

// This test class is used to play with JPQL 
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Transactional// this is required as we are directly using em to do update in the table
class JPQLTests {

	@Autowired
	EntityManager em;
	
	
	private static final Logger logger = LoggerFactory.getLogger(JPQLTests.class);

	@Test
	@Order(1)
	// using JPQL examples at https://www.objectdb.com/java/jpa/query/jpql/update
	void testFindAll() {
		List resultList = em.createQuery("select c from Course c").getResultList();
		logger.info("JPQL-> select * example. size of courses -> {}\n",resultList.size());
		
		Course course1 = em.createQuery("select c from Course c where c.id=:id", Course.class).setParameter("id", 10001l).getSingleResult();
		logger.info("JPQL-> select conditional example. Course name is {}", course1.getName());
		
		// Using named parameters
		/*
		 * int updateCount =
		 * em.createQuery("update Course as c set c.name=:name where c.id=:id")
		 * .setParameter("name", "new course name") .setParameter("id", 10001l)
		 * .executeUpdate();
		 */
		
		// using positional parameters. In earlier versions of JPA only '?' was used, which
		// is no more supported, it should now be like '?1'
		int updateCount = em.createQuery("update Course as c set c.name=?1 where c.id=?2")
				  .setParameter(1, "new course name")
				  .setParameter(2, 10001l)
				  .executeUpdate();
			
		//Native query can also fired using createNativeQuery. It should be noted that objects returned from native query are not managed by em
		//the entities returned from a native query should be refreshed
		
		logger.info("JPQL-> update selective example, also shows usage of named parameter. Update count is {}", updateCount);
	}

}
