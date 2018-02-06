package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.Enquiry;
import com.project.repository.InboxRespository;
import com.project.service.InboxService;

@Controller
public class InboxController {
	@Autowired
	private InboxRespository inboxrepository;
	
	@Autowired
	private InboxService inboxservice;
	
	private ArrayList<Enquiry> enquiryList;
	

	@GetMapping(value="/inbox")
	public String inbox(Model model) {
		List<Enquiry> listEnquiry = inboxservice.GetEnquiries();
		for (Enquiry enquiry: listEnquiry) {
			enquiryList.add(enquiry);
		}
		
//		model.addAttribute("enquiries", enquiryList);
		model.addAttribute("enquiries", inboxrepository.findAll());

		return "/adminMail/inbox";
	}
	
}
