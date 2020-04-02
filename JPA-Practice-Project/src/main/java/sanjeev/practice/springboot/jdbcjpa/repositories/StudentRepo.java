package sanjeev.practice.springboot.jdbcjpa.repositories;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sanjeev.practice.springboot.jdbcjpa.entities.Student;

@Repository
public class StudentRepo extends AbstractRepo<Student>{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentRepo.class);

	@Override
	public void delete(Student student) {
		if(Objects.isNull(student)) {
			logger.error("Student->{} is null. cannot delete a null");
			return ;
		}
		Student StudentToDelete = findById(student.getId());
		em.remove(StudentToDelete);
	}
	protected StudentRepo() {
		t= new Student();
	}
	
}
