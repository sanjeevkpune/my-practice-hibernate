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
		@NamedQuery(name = "findAllPassports", query = "select p from Passport p") ,
		@NamedQuery(name = "deleteAllPassports", query = "delete from Passport")
		}
)
/*
 create table passport (
 
       id bigint not null,
        creation_time timestamp,
        last_update_time timestamp,
        number varchar(10) not null,
        primary key (id)
   )
   */
public class Passport {
	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	
	@Column(length = 10, nullable = false)
	private String number;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateTime;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime creationTime;
	
	
	
	


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public Long getId() {
		return id;
	}


	public Passport() {
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
		return String.format("Passport [id=%s, number=%s, lastUpdateTime=%s, creationTime=%s]", id, number, lastUpdateTime,
				creationTime);
	}
	
	
	
	
	
}
