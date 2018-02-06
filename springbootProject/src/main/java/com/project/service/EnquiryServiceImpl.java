package com.project.service;

import java.util.Date;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EnquiryServiceImpl implements EnquiryService{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addEnquiry(String name, String email, String subject, String message, Date date_time){    	
    	
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO enquiry(name, email, subject, message, date_time)VALUES(?, ?, ?, ?, ?)",name, email, subject, message, date_time);
    }
    
    

}
