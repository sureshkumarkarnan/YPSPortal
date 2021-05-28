package com.yps.ypsconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.yps.ypsconnect.model.Student;


public interface YPSConnectStudentRepository  extends JpaRepository<Student, Long> {

	
	
}
