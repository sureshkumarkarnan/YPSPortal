package com.yps.ypsconnect;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yps.ypsconnect.model.Admission;
import com.yps.ypsconnect.model.Admission.StudentType;
import com.yps.ypsconnect.model.Course;
import com.yps.ypsconnect.model.EmailAddress;
import com.yps.ypsconnect.model.PhoneNumber;
import com.yps.ypsconnect.model.Student;
import com.yps.ypsconnect.model.Student.Gender;
import com.yps.ypsconnect.repositories.YPSConnectStudentRepository;

import com.yps.ypsconnect.service.YPSConnectStudentService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.yps.ypsconnect.repositories")
public class YpsPortalApplication implements CommandLineRunner {

	
	@Autowired
	private  YPSConnectStudentService StudentService;
	
	public static void main(String[] args) {
		SpringApplication.run(YpsPortalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		/*
		 * // List<Student> students = StudentService.listAllStudents();
		 * StudentWithParent sp = new StudentWithParent(); sp.setRegId("20190003");
		 * sp.setFname("Malniss"); sp.setActive(true);
		 * sp.setAddress("no 87,perungalathur,chennai 600087"); PhoneNumber ph = new
		 * PhoneNumber("8951729964"); sp.setContact(ph); EmailAddress email = new
		 * EmailAddress("rameshh@srm.org"); sp.setDOB(new Date(2016,4,2));
		 * sp.setFathername("ramesh"); sp.setGender(Gender.FEMALE);
		 * sp.setAdmission(null);
		 * 
		 * StudentService.addStudent(sp);
		 */
		 
//		Course course = new Course();
//		course.setCourseName("PREKG");
//		course.setStudentType(StudentType.NEW);
//		course.setActivityFee(2000.00);
//		course.setApplicationFee(300.00);
//		course.setRegistrationFee(8000.00);
//		course.setStationaryFee(5000.00);
//		course.setTerm1Fee(4000.00);
//		course.setTerm2Fee(4000.00);
//		course.setTerm3Fee(4000.00);
//		Admission admission = new Admission();
//		admission.setEnrolled_course(course);
//		admission.setAmount_paid(0.00);
//		admission.setCleared(false);
//		admission.setComments(null);
//		admission.setDiscount(0);
//		admission.setTotalfee(course.getActivityFee() + course.getApplicationFee() + course.getRegistrationFee() + course.getTerm1Fee() + course.getTerm2Fee() + course.getTerm3Fee());
//		admission.set
	}

}
