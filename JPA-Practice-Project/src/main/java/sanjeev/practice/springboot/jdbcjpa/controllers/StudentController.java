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

import sanjeev.practice.springboot.jdbcjpa.entities.Student;
import sanjeev.practice.springboot.jdbcjpa.services.StudentService;

@RestController("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students/{id}")
	public Student findStudentById(@PathVariable("id") int id) {
		return studentService.findStudentById(id);
	}

	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return studentService.findAllStudents();
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		 return studentService.saveStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/students")
	public void deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
	}
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable("id") long id) {
		studentService.deleteStudentById(id);
	}
	
	@DeleteMapping(value = "/students/all" )
	public void deleteAllStudents() {
		studentService.deleteAllStudents();
	}
}
