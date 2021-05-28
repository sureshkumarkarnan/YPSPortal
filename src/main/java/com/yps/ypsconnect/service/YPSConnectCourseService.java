package com.yps.ypsconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yps.ypsconnect.model.Course;
import com.yps.ypsconnect.repositories.YPSConnectCourseRepository;




@Service
public class YPSConnectCourseService {

	private YPSConnectCourseRepository CourseRepository;
 

    @Autowired
    public void setCourseRepository(YPSConnectCourseRepository CourseRepository) {
        this.CourseRepository = CourseRepository;
    }
    
    
    
    public List<Course> listAllCourses() {

        return CourseRepository.findAll();
    }

	public Course getOne(Long id) {
		// TODO Auto-generated method stub
		return CourseRepository.getOne(id);
	}


	public void saveCourse(Course Course) {
		// TODO Auto-generated method stub
		CourseRepository.save(Course);
	}


	public void delete(Long id) {
		// TODO Auto-generated method stub
		CourseRepository.deleteById(id);
	}
	
}
