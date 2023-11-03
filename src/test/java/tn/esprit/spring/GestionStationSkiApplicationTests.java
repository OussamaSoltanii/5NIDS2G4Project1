package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.*;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GestionStationSkiApplicationTests {
	@Autowired
	ICourseServices cs;
	@Autowired
	IInstructorServices is;
	@Autowired
	IPisteServices ps;
	@Autowired
	ISkierServices ss;
	@Autowired
	ISubscriptionServices sub;
	@Autowired
	IRegistrationServices rs;
	@Test
	public void retrieveAllCourses() {
		List<Course> courseList=cs.retrieveAllCourses();
		Assertions.assertNotNull(courseList);

	}
	@Test
	public void retrieveAllInstructors() {
		List<Instructor> instructorList=is.retrieveAllInstructors();
		Assertions.assertNotNull( instructorList);

	}
	@Test
	public void retrieveAllPistes() {
		List<Piste> pisteList=ps.retrieveAllPistes();
		Assertions.assertNotNull(pisteList);

	}
	@Test
	@Order(1)
	public void retrieveAllSkiers() {
		List<Skier> skierList = ss.retrieveAllSkiers();
		Assertions.assertNotNull(skierList);

	}
	@Test
	public void numWeeksCourseOfInstructorBySupport() {
		List<Integer> registration=rs.numWeeksCourseOfInstructorBySupport(1L,Support.SNOWBOARD);
		Assertions.assertNotNull(registration);
	}
	@Test
	public void retrieveSubscriptionById() {
		Subscription subscription=sub.retrieveSubscriptionById(1L);
		Assertions.assertNotNull(subscription);
	}

}
