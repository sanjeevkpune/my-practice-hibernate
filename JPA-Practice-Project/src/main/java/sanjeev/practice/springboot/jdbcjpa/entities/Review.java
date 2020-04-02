package sanjeev.practice.springboot.jdbcjpa.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "findAllReviews", query = "select r from Review r") ,
		@NamedQuery(name = "deleteAllReviews", query = "delete from Review")
		}
)
 
/*
    create table review (
       id bigint not null,
        creation_time timestamp,
        description varchar(1000) not null,
        last_update_time timestamp,
        rating varchar(10) not null,
        primary key (id)
    )
*/
public class Review {
	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	
	@Column(length = 10, nullable = false)
	private String rating;
	
	@Column(length = 1000, nullable = false)
	private String description;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateTime;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime creationTime;
	

	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public Review() {
		super();
	}
	
	
	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	@Override
	public String toString() {
		return String.format("Review [id=%s, rating=%s, description=%s..., lastUpdateTime=%s, creationTime=%s]", 
				id, rating,  description.subSequence(0, 25) , lastUpdateTime,creationTime);
	}
	
	
	
	
	
}
