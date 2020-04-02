package sanjeev.practice.springboot.jdbcjpa.repositories;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sanjeev.practice.springboot.jdbcjpa.entities.Passport;;

@Repository
public class PassportRepo extends AbstractRepo<Passport>{
	
	
	private static final Logger logger = LoggerFactory.getLogger(PassportRepo.class);

	
	protected PassportRepo() {
		t= new Passport();
	}

	@Override
	public void delete(Passport passport) {
		if(Objects.isNull(passport)) {
			logger.error("Passport->{} is null. cannot delete a null");
			return ;
		}
		Passport PassportToDelete = findById(passport.getId());
		em.remove(PassportToDelete);
	}
	
}
