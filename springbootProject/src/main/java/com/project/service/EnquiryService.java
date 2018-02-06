package com.project.service;

import java.util.Date;


public interface EnquiryService {
	 void addEnquiry(String name, String email, String subject, String message, Date date_time);
	 
}
