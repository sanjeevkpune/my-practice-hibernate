package sanjeev.practice.springboot.jdbcjpa.services;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanjeev.practice.springboot.jdbcjpa.DAO.PersonDAO;
import sanjeev.practice.springboot.jdbcjpa.models.Person;

@Service
public class PesronService {
	@Autowired
	private PersonDAO personDao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(PesronService.class);

	// call personDao for carrying on CRUD operations on Person object
	public List<Person> getAllPersons(){
		logger.info("START PesronService->getAllPersons()");
		
		List<Person> allPersons = personDao.findAll();
		
		logger.info("END PesronService->getAllPersons()");
		return  allPersons;
	}

	public Person findPersonById(int id) {
		Person person = personDao.findById(id);
		return person;
	}
	
	public void deletePersonById(int id) {
		personDao.deleteById(id);
		
	}
	
	public Person updatePerson(Person person) {
		Person p = personDao.insertUpdate(person);
		if(Objects.nonNull(p))
			return p;
		return null;
	}
	
	public Person insert(Person person) {
		Person p = personDao.insertUpdate(person);
		if(Objects.nonNull(p))
			return p;
		return null;
	}
}
