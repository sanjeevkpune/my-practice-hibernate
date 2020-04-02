package sanjeev.practice.springboot.jdbcjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanjeev.practice.springboot.jdbcjpa.entities.Review;
import sanjeev.practice.springboot.jdbcjpa.repositories.ReviewRepo;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo reviewRepo;
	
	public Review findReviewById(int id) {
		return reviewRepo.findById((long) id);
	}

	public List<Review> findAllReviews(){
		return reviewRepo.findAll();
	}
	
	public void deleteReviewById(long id) {
		reviewRepo.deleteById(id);
	}
	
	public void deleteReview(Review review) {
		reviewRepo.delete(review);
	}
	
	public Review saveReview(Review review) {
		return reviewRepo.save(review);
	}
	
	public void deleteAllReviews() {
		reviewRepo.deleteAll();
	}
	
}
