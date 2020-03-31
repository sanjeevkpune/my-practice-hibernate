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

import sanjeev.practice.springboot.jdbcjpa.entities.Course;
import sanjeev.practice.springboot.jdbcjpa.services.CourseService;

@RestController("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses/{id}")
	public Course findCourseById(@PathVariable("id") int id) {
		return courseService.findCourseById(id);
	}

	@GetMapping("/courses")
	public List<Course> findAllCourses(){
		return courseService.findAllCourses();
	}
	
	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course course) {
		 return courseService.saveCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@DeleteMapping("/courses")
	public void deleteCourse(@RequestBody Course course) {
		courseService.deleteCourse(course);
	}
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable("id") long id) {
		courseService.deleteCourseById(id);
	}
	
	@DeleteMapping(value = "/courses/all" )
	public void deleteAllCourses() {
		courseService.deleteAllCourses();
	}
}
