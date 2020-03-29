package sanjeev.practice.springboot.jdbcjpa.controllers;

import java.util.List;

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
	public List<Person> getAllPersons(){
		List<Person> allPersons = personService.getAllPersons();
		
		return  allPersons;
	}
	
	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable("id") int id) {
		Person person = personService.findPersonById(id);
		return person;
	}
	
	@DeleteMapping("/persons/{id}")
	public String deletePersonById(@PathVariable("id") int id) {
		boolean result = personService.deletePersonById(id);
		if(result) {
			return "Delete operatin with ID -"+id+" is successful";
		}
		return "Delete operatin with ID -"+id+" failed";
	}
	
	@PutMapping(value = "/persons", consumes = "application/json", produces = "application/json")
	public String updatePerson(@RequestBody Person person) {
		boolean result =personService.updatePerson(person);
		
		if(result) {
			return person.toString()+" updated successfully";
		}
		return person.toString()+" update failed ";
	}
	
	@PostMapping("/persons")
	public String insert(@RequestBody Person person) {
		boolean result =personService.insert(person);
		if(result) {
			return person.toString()+" inserted successfully";
		}
		return person.toString()+" insertion failed ";
	}

}
