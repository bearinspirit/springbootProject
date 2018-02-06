package com.project.service;

import java.util.Date;


public interface EnquiryService {
	
	 //add submitted enquiry to DB
	 void addEnquiry(String name, String email, String subject, String message, Date date_time);
	 
}
