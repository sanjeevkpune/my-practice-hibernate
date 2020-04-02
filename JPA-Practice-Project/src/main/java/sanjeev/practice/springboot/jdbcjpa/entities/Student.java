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
		@NamedQuery(name = "findAllStudents", query = "select s from Student s") ,
		@NamedQuery(name = "deleteAllStudents", query = "delete from Student")
		}
)


/*
    
    create table student (
       id bigint not null,
        creation_time timestamp,
        last_update_time timestamp,
        name varchar(100) not null,
        primary key (id)
    )

*/
public class Student {
	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateTime;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime creationTime;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Student() {
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
		return String.format("Student [id=%s, name=%s, lastUpdateTime=%s, creationTime=%s]", id, name, lastUpdateTime,
				creationTime);
	}
	
	
	
	
	
}
