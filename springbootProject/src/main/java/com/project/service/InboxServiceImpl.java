package com.project.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.project.model.Enquiry;

@Service
public class InboxServiceImpl  implements InboxService{
	@Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    

    
    public List GetEnquiries(){    	
    	
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM enquiry";
        List enquiryList = new ArrayList();
        jdbcTemplate.query(sql, new ResultSetExtractor() {
                public List extractData(ResultSet rs) throws SQLException {
                        
                        while (rs.next()) {
                        		Enquiry enquiry = new Enquiry();
                        			enquiry.setId(rs.getLong("id"));
                        			enquiry.setDate_Time((Date)rs.getDate("date_time"));
                        			enquiry.setName(rs.getString("name"));
                        			enquiry.setEmail(rs.getString("email"));
                        			enquiry.setSubject(rs.getString("subject"));
                        			enquiry.setMessage(rs.getString("message"));
                        }
                        return enquiryList;
                }
        });
        return enquiryList;

       
    }

}
