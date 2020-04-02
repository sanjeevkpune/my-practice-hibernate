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

import sanjeev.practice.springboot.jdbcjpa.entities.Passport;
import sanjeev.practice.springboot.jdbcjpa.services.PassportService;

@RestController("/passports")
public class PassportController {
	
	@Autowired
	private PassportService passportService;
	
	@GetMapping("/passports/{id}")
	public Passport findPassportById(@PathVariable("id") int id) {
		return passportService.findPassportById(id);
	}

	@GetMapping("/passports")
	public List<Passport> findAllPassports(){
		return passportService.findAllPassports();
	}
	
	@PostMapping("/passports")
	public Passport createPassport(@RequestBody Passport Passport) {
		 return passportService.savePassport(Passport);
	}
	
	@PutMapping("/passports")
	public Passport updatePassport(@RequestBody Passport Passport) {
		return passportService.savePassport(Passport);
	}
	
	@DeleteMapping("/passports")
	public void deletePassport(@RequestBody Passport Passport) {
		passportService.deletePassport(Passport);
	}
	@DeleteMapping("/passports/{id}")
	public void deletePassport(@PathVariable("id") long id) {
		passportService.deletePassportById(id);
	}
	
	@DeleteMapping(value = "/passports/all" )
	public void deleteAllPassports() {
		passportService.deleteAllPassports();
	}
}
