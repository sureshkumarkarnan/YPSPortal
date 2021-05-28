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


@Controller

public class YPSConnectStudentController {

	private final YPSConnectStudentService StudentService;
	
	@Autowired
	public YPSConnectStudentController(YPSConnectStudentService StudentService) {
		this.StudentService = StudentService;
	}
	
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
    public String viewStudents(Model model) {
        System.out.println("Returning students:");
        return  findPaginated(1, "fname", "asc", model);	
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
       
        return  "redirect:/students";	
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
	
	}
	
}
