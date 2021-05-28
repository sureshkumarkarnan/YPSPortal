package com.yps.ypsconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yps.ypsconnect.model.Admission;
import com.yps.ypsconnect.repositories.YPSConnectAdmissionRepository;
import com.yps.ypsconnect.repositories.YPSConnectAdmissionRepository;



@Service
public class YPSConnectAdmissionService {

	private YPSConnectAdmissionRepository admissionRepository;
 

    @Autowired
    public void setAdmissionRepository(YPSConnectAdmissionRepository AdmissionRepository) {
        this.admissionRepository = AdmissionRepository;
    }
    
    
    
    public List<Admission> listAllAdmissions() {

        return admissionRepository.findAll();
    }

	public Admission getOne(Long id) {
		// TODO Auto-generated method stub
		return admissionRepository.getOne(id);
	}


	public void saveAdmission(Admission Admission) {
		// TODO Auto-generated method stub
		admissionRepository.save(Admission);
	}


	public void delete(Long id) {
		// TODO Auto-generated method stub
		admissionRepository.deleteById(id);
	}
	
}
