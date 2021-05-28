package com.yps.ypsconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yps.ypsconnect.model.Teacher;
import com.yps.ypsconnect.repositories.YPSConnectTeacherRepository;




@Service
public class YPSConnectTeacherService {

	private YPSConnectTeacherRepository TeacherRepository;
 

    @Autowired
    public void setTeacherRepository(YPSConnectTeacherRepository TeacherRepository) {
        this.TeacherRepository = TeacherRepository;
    }
    
    
    
    public List<Teacher> listAllTeachers() {

        return TeacherRepository.findAll();
    }

	public Teacher getOne(Integer id) {
		// TODO Auto-generated method stub
		return TeacherRepository.getOne(id);
	}


	public void saveTeacher(Teacher Teacher) {
		// TODO Auto-generated method stub
		TeacherRepository.save(Teacher);
	}


	public void delete(Integer id) {
		// TODO Auto-generated method stub
		TeacherRepository.deleteById(id);
	}
	
}
