package sanjeev.practice.springboot.jdbcjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanjeev.practice.springboot.jdbcjpa.entities.Passport;
import sanjeev.practice.springboot.jdbcjpa.repositories.PassportRepo;

@Service
public class PassportService {
	@Autowired
	private PassportRepo PassportRepo;
	
	public Passport findPassportById(int id) {
		return PassportRepo.findById((long) id);
	}

	public List<Passport> findAllPassports(){
		return PassportRepo.findAll();
	}
	
	public void deletePassportById(long id) {
		PassportRepo.deleteById(id);
	}
	
	public void deletePassport(Passport passport) {
		PassportRepo.delete(passport);
	}
	
	public Passport savePassport(Passport passport) {
		return PassportRepo.save(passport);
	}
	
	public void deleteAllPassports() {
		PassportRepo.deleteAll();
	}
	
}
