package sanjeev.practice.springboot.jdbcjpa.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sanjeev.practice.springboot.jdbcjpa.models.Person;
import sanjeev.practice.springboot.jdbcjpa.services.PesronService;

@RestController("/persons")
public class PersonController {

	@Autowired
	PesronService personService;

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		List<Person> allPersons = personService.getAllPersons();

		return allPersons;
	}

	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable("id") int id) {
		Person person = personService.findPersonById(id);
		return person;
	}

	@DeleteMapping("/persons/{id}")
	public void deletePersonById(@PathVariable("id") int id) {
		personService.deletePersonById(id);
		
	}

	@PutMapping(value = "/persons", consumes = "application/json", produces = "application/json")
	public String updatePerson(@RequestBody Person person) {
		String res =null;
		if(Objects.nonNull(person)) {
			if(person.getId() !=0) {
				Person result = personService.updatePerson(person);

				if (Objects.nonNull(result)) {
					res= result.toString() + " updated successfully";
				}
				else{
					res = person.toString() + " update failed ";
				}
			}else {
				res = insert(person);
			}
		}
			
		return res;
	}

	@PostMapping("/persons")
	public String insert(@RequestBody Person person) {
		Person result = personService.updatePerson(person);

		if (Objects.nonNull(result)) {
			return result.toString() + " inserted successfully";
		}
		return person.toString() + " insertion failed ";
	}

}
