package com.yps.ypsconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yps.ypsconnect.model.Student;
import com.yps.ypsconnect.repositories.YPSConnectStudentRepository;



@Service
public class YPSConnectStudentService {

	private YPSConnectStudentRepository studentRepository;


    @Autowired
    public void setStudentRepository(YPSConnectStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
   
    
    public List<Student> listAllStudents() {

        return studentRepository.findAll();
    }


	public Optional<Student> getStudent(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}



	public void delete(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}


	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	public void editStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}


    public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.studentRepository.findAll(pageable);	
	}
	
}
