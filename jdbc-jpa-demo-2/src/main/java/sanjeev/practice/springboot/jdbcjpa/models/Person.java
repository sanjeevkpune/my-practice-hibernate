package sanjeev.practice.springboot.jdbcjpa.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries(
		value = {
				@NamedQuery(name = "findAllPersons", query = "select p from Person p")
		}
		)

public class Person {

	@NotNull(message = "name can not be null")
	private String name;
	@Id
	@GeneratedValue
	private int id;
	private String location;
	private Date birthDate;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name,  String location, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
		this.birthDate = birthDate;
	}
	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return String.format("\nPerson [name=%s, id=%s, location=%s, birthDate=%s]", name, id, location, birthDate);
	}
	@Override
	public int hashCode() {
		return Objects.hash(birthDate, id, location, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(birthDate, other.birthDate) && id == other.id && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name);
	}
	
	
}
