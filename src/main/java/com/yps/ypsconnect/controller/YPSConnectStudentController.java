package com.yps.ypsconnect.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.yps.ypsconnect.model.Student;
import com.yps.ypsconnect.repositories.YPSConnectStudentRepository;
import com.yps.ypsconnect.service.YPSConnectStudentService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class YPSConnectStudentController {

	private final YPSConnectStudentService StudentService;
	
	@Autowired
	public YPSConnectStudentController(YPSConnectStudentService StudentService) {
		this.StudentService = StudentService;
	}
	
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> list(Model model) {
        System.out.println("Returning students:");
        return  StudentService.listAllStudents();
    }
	
	  @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
	    public Student getStudent(@PathVariable("id") Long id) {
	     
		  Optional<Student> s = StudentService.getStudent(id);
	        System.out.println("Returning student with id :"+ id);
	        return s.get();
	    }
	  
	
	 @RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	    public void deleteStudent(@PathVariable("id") Long id) {
		 StudentService.delete(id);
	    }
	 		
	@RequestMapping(value="/students", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	public void addStudent(@RequestBody Student student) {
        // save employee to database
	    System.out.println("Creating new  student :");
		StudentService.addStudent(student);
    }

	
	@RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable("id") Long id) {
		try {
	        System.out.println("REST::editStudent :: "+ id);
	     //   Optional<Student> s = StudentService.getStudent(id);
			StudentService.editStudent(student);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }  
    }
	
/*	@RequestMapping(value = "/students", method = RequestMethod.GET)
    public String viewStudents(Model model) {
        System.out.println("Returning students:");
        return  findPaginated(1, "fname", "asc", model);	
    }
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> list(Model model) {
        System.out.println("Returning students:");
        return  StudentService.listAllStudents();
    }
	
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		
		int pageSize = 5;
		
		Page<Student> page = StudentService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Student> listStudents = page.getContent();
		
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listStudents", listStudents);
		return "list-employees";
	
	}*/
	
}
