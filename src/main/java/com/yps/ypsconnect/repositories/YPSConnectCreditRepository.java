package com.yps.ypsconnect.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.yps.ypsconnect.model.Course;
import com.yps.ypsconnect.model.Credit;



public interface YPSConnectCreditRepository extends JpaRepository<Credit, Long> {

	
}
