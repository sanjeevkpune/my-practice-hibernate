package sanjeev.practice.springboot.jdbcjpa.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "findAllCourses", query = "select c from Course c") ,
		@NamedQuery(name = "deleteAllCourses", query = "delete from Course")
		}
)


/*
 * Hibernate fires this create table command first
 * then only data.sql is read and executed
 * below insert queries from data.sql are fired
 
INSERT INTO COURSE (ID, NAME) VALUES(10001, 'Java')
INSERT INTO COURSE (ID, NAME) VALUES(10002, 'Spring')
INSERT INTO COURSE (ID, NAME) VALUES(10003, 'Devops')
 create table course (
 
	       id bigint not null,
	        creation_time timestamp,
	        last_update_time timestamp,
	        name varchar(255) not null,
	        primary key (id)
	    )
 */
public class Course {
	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	@NotNull
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateTime;
	
	@CreationTimestamp
	private LocalDateTime creationTime;
	
	/*// springframework annotations
	 * @LastModifiedDate
	 * 
	 * @LastModifiedBy
	 * 
	 * @CreatedBy
	 * 
	 * @CreatedDate
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public Course(String name) {
		super();
		this.name = name;
	}
	
	protected Course() {
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
		return String.format("Course [id=%s, name=%s, lastUpdateTime=%s, creationTime=%s]", id, name, lastUpdateTime,
				creationTime);
	}
	
	
	
	
	
}
