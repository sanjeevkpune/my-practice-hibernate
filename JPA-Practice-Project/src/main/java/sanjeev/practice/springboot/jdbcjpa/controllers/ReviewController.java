package sanjeev.practice.springboot.jdbcjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sanjeev.practice.springboot.jdbcjpa.entities.Review;
import sanjeev.practice.springboot.jdbcjpa.services.ReviewService;

@RestController("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/reviews/{id}")
	public Review findReviewById(@PathVariable("id") int id) {
		return reviewService.findReviewById(id);
	}

	@GetMapping("/reviews")
	public List<Review> findAllReviews(){
		return reviewService.findAllReviews();
	}
	
	@PostMapping("/reviews")
	public Review createReview(@RequestBody Review review) {
		 return reviewService.saveReview(review);
	}
	
	@PutMapping("/reviews")
	public Review updateReview(@RequestBody Review review) {
		return reviewService.saveReview(review);
	}
	
	@DeleteMapping("/reviews")
	public void deleteReview(@RequestBody Review review) {
		reviewService.deleteReview(review);
	}
	@DeleteMapping("/reviews/{id}")
	public void deleteReview(@PathVariable("id") long id) {
		reviewService.deleteReviewById(id);
	}
	
	@DeleteMapping(value = "/reviews/all" )
	public void deleteAllReviews() {
		reviewService.deleteAllReviews();
	}
}
