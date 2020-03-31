package sanjeev.practice.springboot.jdbcjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanjeev.practice.springboot.jdbcjpa.entities.Course;
import sanjeev.practice.springboot.jdbcjpa.repositories.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo courseRepo;
	
	public Course findCourseById(int id) {
		return courseRepo.findCourseById((long) id);
	}

	public List<Course> findAllCourses(){
		return courseRepo.findAllCourses();
	}
	
	public void deleteCourseById(long id) {
		courseRepo.deleteCourseById(id);
	}
	
	public void deleteCourse(Course course) {
		courseRepo.deleteCourse(course);
	}
	
	public Course saveCourse(Course course) {
		return courseRepo.saveCourse(course);
	}
	
	public void deleteAllCourses() {
		courseRepo.deleteAllCourses();
	}
	
}
