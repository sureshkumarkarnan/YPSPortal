package com.yps.ypsconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YPSConnectController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("controller:login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String root() {
		System.out.println("root :strtup" );
		return "redirect:/home";
	}

	 @RequestMapping(value="/home", method = RequestMethod.GET)
	    public ModelAndView home(){
			System.out.println("controller:admin home");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("home");
	        return modelAndView;
	    }
	 

}