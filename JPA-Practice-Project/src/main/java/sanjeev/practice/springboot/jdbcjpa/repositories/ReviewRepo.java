package sanjeev.practice.springboot.jdbcjpa.repositories;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sanjeev.practice.springboot.jdbcjpa.entities.Review;

@Repository
public class ReviewRepo  extends AbstractRepo<Review>{
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewRepo.class);

	protected ReviewRepo() {
		t= new Review();
	}

	@Override
	public void delete(Review review) {
		if(Objects.isNull(review)) {
			logger.error("Review->{} is null. cannot delete a null");
			return ;
		}
		Review ReviewToDelete = findById(review.getId());
		em.remove(ReviewToDelete);
		
	}
	
}
