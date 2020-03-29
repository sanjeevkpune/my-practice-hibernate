package sanjeev.practice.springboot.jdbcjpa.DAO;

import java.util.List;

import sanjeev.practice.springboot.jdbcjpa.models.Person;

public interface ModelDAO<T> {
	public List<T> findAll();
	public Person findById(int id);
	public int deleteById(int id);
	public int updatePerson(T object);
	public int insert(T object);
}
