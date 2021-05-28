package com.yps.ypsconnect.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.yps.ypsconnect.model.Course;



public interface YPSConnectCourseRepository extends JpaRepository<Course, Long> {

	
}
