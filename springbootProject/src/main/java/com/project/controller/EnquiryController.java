package com.project.controller;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = "/enquiry")
    public String enquiry() {
        return "/enquiry/enquiry";
    }
	
	
	@PostMapping(value="/enquiry")
	public String addEnquiry(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("subject") String subject, 
			@RequestParam("message") String message, Date date_time) {
		
		enquiryservice.addEnquiry(name, email, subject, message, date_time);
		System.out.println("Enquiry created = " + subject +  "was sent by " + email + " on " + date_time);
		return "/enquiry/enquiry";
		
	}
}
