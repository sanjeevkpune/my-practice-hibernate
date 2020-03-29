package sanjeev.practice.springboot.jdbcjpa.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sanjeev.practice.springboot.jdbcjpa.models.Person;

@Repository
public class PersonDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll(){
		logger.info("START -- ?", getClass().getSimpleName()+"-> findAll");
		
		List<Person> allPersons = jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
		
		logger.info("END -- ?", getClass().getSimpleName()+"-> findAll");
		return allPersons;
	}
	
	public Person findById(int id) {
		Person person =null;
		try {
		person = jdbcTemplate.queryForObject(
				"select * from person where id=?", new Object[] {id}, new PersonRowMapper());
		}catch (Exception e) {
			logger.error("Error Finding person with ID "+id, e.getCause());
		}
		return person;
	}
	
	public int deleteById(int id) {
		int updatedRows = jdbcTemplate.update("delete from person where id=?", id);
		return updatedRows;
	}
	
	public int updatePerson(Person person) {
		int updatedRows = jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?", 
						person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
		return updatedRows;
	}
	
	public int insert(Person person) {
		int updatedRows = jdbcTemplate.update("insert into person "
				+ "(id, name, location, birth_date)"
				+ "values (?, ?, ?, ?)", 
				person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
		return updatedRows;
	}
	// Custom Row mapper for person
	// advisable to create inner mapper for each Type and let the object handle the mapping itself
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
}
