package com.yps.ypsconnect.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.yps.ypsconnect.model.Admission;



public interface YPSConnectAdmissionRepository extends JpaRepository<Admission, Long> {

	
}
