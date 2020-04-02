package sanjeev.practice.springboot.jdbcjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanjeev.practice.springboot.jdbcjpa.entities.Student;
import sanjeev.practice.springboot.jdbcjpa.repositories.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;
	
	public Student findStudentById(int id) {
		return studentRepo.findById((long) id);
	}

	public List<Student> findAllStudents(){
		return studentRepo.findAll();
	}
	
	public void deleteStudentById(long id) {
		studentRepo.deleteById(id);
	}
	
	public void deleteStudent(Student student) {
		studentRepo.delete(student);
	}
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteAllStudents() {
		studentRepo.deleteAll();
	}
	
}
