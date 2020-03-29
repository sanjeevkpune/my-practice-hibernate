package sanjeev.practice.springboot.jdbcjpa.DAO;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sanjeev.practice.springboot.jdbcjpa.models.Person;

@Repository
@Transactional
// We will use hibernate instead of JDBC template
public class PersonDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

	@PersistenceContext
	EntityManager entityManager;

	public List<Person> findAll(){
		logger.info("START -- ?", getClass().getSimpleName()+"-> findAll");
		
		List<Person> allPersons =  entityManager.createNamedQuery("findAllPersons", Person.class).getResultList();
		
		logger.info("END -- ?", getClass().getSimpleName()+"-> findAll");
		return allPersons;
	}
	
	public Person findById(int id) {
		Person person =null;
		try {
		person = entityManager.find(Person.class, id);
		}catch (Exception e) {
			logger.error("Error Finding person with ID "+id, e.getCause());
		}
		return person;
	}
	
	public void deleteById(int id) {
		Person p = findById(id);
		entityManager.remove(p);
	}
	
	
	public Person insertUpdate(Person person) {
		Person p = entityManager.merge(person);
		if(Objects.nonNull(p)) {
			return p;
		}
		return null;
	}
	
}
