package com.project.controller;

import java.sql.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.repository.EnquiryRepository;
import com.project.service.EnquiryService;
import com.project.model.Enquiry;

@Controller
public class EnquiryController {
	
	@Autowired
	private EnquiryRepository enquiryrepository;
	
	@Autowired
	private EnquiryService enquiryservice;

	public String addEnquiry(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("subject") String subject, 
			@RequestParam("message") String message, Date date_time) {
		
		enquiryservice.addEnquiry(name, email, subject, message, date_time);
		System.out.println("Enquiry created = " + subject +  "was sent by " + email + " on " + date_time);
		return "/enquiry/enquiry";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	public String finalString = null;
	
	@Autowired
	private EnquiryRepository enquiryRepository;

	@PostMapping(value="/enquiry")
	public String addAnEnquiry(@ModelAttribute @Valid Enquiry newEnquiry, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			System.out.println("BINDING RESULT ERROR");
			return "redirect:/enquiry";
			
		} else {
			model.addAttribute("enquiry", newEnquiry);
			
			enquiryservice.addEnquiry(newEnquiry.getName(), newEnquiry.getEmail(), newEnquiry.getSubject(), newEnquiry.getMessage(), newEnquiry.getDate_Time());
				
			return "redirect:/enquiry";
		}
	}
	
	@GetMapping(value="/enquiry")
	public String viewTheForm(Model model){
		Enquiry newEnquiry = new Enquiry();
		model.addAttribute("enquiry",newEnquiry);
		return "/enquiry/enquiry";
	}
	
	public String checkNullString(String str){
		String endString = null;
		if(str == null || str.isEmpty()){
			System.out.println("yes it is empty");
			str = null;
			Optional<String> opt = Optional.ofNullable(str);
			endString = opt.orElse("None");
			System.out.println("endString : " + endString);
		}
		else{
			; //do nothing
		}
		return endString;
		
	}
	
	
	
}
