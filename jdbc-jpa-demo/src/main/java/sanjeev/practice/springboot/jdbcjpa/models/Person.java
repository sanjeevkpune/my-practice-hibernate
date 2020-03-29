package sanjeev.practice.springboot.jdbcjpa.models;

import java.util.Date;

public class Person {

	private String name;
	private int id;
	private String location;
	private Date birthDate;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int id, String location, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
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
}
