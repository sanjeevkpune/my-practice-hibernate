package sanjeev.practice.springboot.jdbcjpa.repositories;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sanjeev.practice.springboot.jdbcjpa.entities.Course;

@Repository
@Transactional
public class CourseRepo {
	@Autowired
	EntityManager em;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CourseRepo.class);

	public Course findCourseById(Long id) {
		if(Objects.isNull(id)) {
			logger.error("id->{} is null. Use correct input", id);
			return null;
		}
		return em.find(Course.class, id);
	}
	
	public List<Course> findAllCourses(){
		List<Course> resultList = em.createNamedQuery("findAllCourses", Course.class).getResultList();
		if(resultList.size()==0) {
			logger.warn("No course could be found");
		}
		return resultList;
	}
	
	public void deleteCourseById(long id) {
		if(Objects.isNull(id)) {
			logger.error("id->{} is null. Use correct input", id);
			return ;
		}
		Course course = findCourseById(id);
		if(Objects.nonNull(course)) {
			deleteCourse(course);
		}else {
			logger.error("Delete for object with id={} failed. No object found with id={}", id);
		}
	}
	
	public void deleteCourse(Course course) {
		if(Objects.isNull(course)) {
			logger.error("course->{} is null. cannot delete a null");
			return ;
		}
		Course courseToDelete = findCourseById(course.getId());
		em.remove(courseToDelete);
	}
	
	public void deleteAllCourses() {
		em.createNamedQuery("deleteAllCourses").executeUpdate();
	}
	
	public Course saveCourse(Course course) {
		Course updatedCourse = null;
		if(course.getId()!= null) {
			updatedCourse = em.merge(course);
		}else {
			em.persist(course);
			updatedCourse=findCourseById(course.getId());
		}
		return updatedCourse;
		
	}
}
