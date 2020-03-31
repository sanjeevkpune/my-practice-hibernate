package sanjeev.practice.springboot.jdbcjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import sanjeev.practice.springboot.jdbcjpa.entities.Course;
import sanjeev.practice.springboot.jdbcjpa.repositories.CourseRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
// We can use ordering of tests to avoid using dirtiesContext to make the test run much faster
// as it avoids closing and creating context after each test
class CourseRepoTests {
	@Autowired
	CourseRepo courseRepo;

	@Test
	@Order(1)
	void testFindCourseById() {
		Course course = courseRepo.findCourseById(10001l);
		assertEquals("Java", course.getName());
	}

	@Test
	@Order(2)
	void testFindAllCourses() {
		assertEquals(3, courseRepo.findAllCourses().size());
	}

	@Test
	@Order(3)
	//@DirtiesContext
	// with dirtiesContext context will be shutdown and created again after each method
	// this will be very slow
	void testDeleteCourseById() {
		courseRepo.deleteCourseById(10001l);
		Course course = courseRepo.findCourseById(10001l);
		assertNull(course);
	}

	@Test
	@Order(4)
	//@DirtiesContext
	void testDeleteCourse() {
		Course course = courseRepo.findCourseById(10002l);
		assertNotNull(course);
		courseRepo.deleteCourse(course);
		course= courseRepo.findCourseById(10002l);
		assertNull(course);
	}

	@Test
	@Order(7)
	//@DirtiesContext
	void testDeleteAllCourses() {
		courseRepo.deleteAllCourses();
		assertEquals(0, courseRepo.findAllCourses().size());
	}

	@Test
	@Order(5)
	//@DirtiesContext
	void testCreateCourse() {
		Course course = courseRepo.saveCourse(new Course("Cloud Computing"));
		assertNotNull(course.getId());
	}
	
	@Test
	@Order(6)
	//@DirtiesContext
	void testUpdateCourse() {
		
		Course courseToUpdate = courseRepo.findCourseById(10003l);
		courseToUpdate.setName("updated course name");
		Course course = courseRepo.saveCourse(courseToUpdate);
		assertEquals("updated course name", course.getName());
	}

}
