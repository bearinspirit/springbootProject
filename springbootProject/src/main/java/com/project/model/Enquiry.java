package com.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="enquiry")
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	@NotNull(message = "Name cannot be empty!")
	@Size(min=2, max=30, message = "Name must be between {min} to {max} characters!")
	private String name;
	
	@Column(name = "email")
	@NotNull(message = "Email cannot be empty!")
	private String email;
	
	@Column(name = "subject")
	@NotNull(message = "Subject cannot be empty!")
	@Size(min=5, max=50, message = "Subject must be between {min} to {max} characters!")
	private String subject;
	
	@Column(name = "message")
	@NotNull(message = "Message cannot be empty!")
	@Size(min=10, max=2000, message = "Message must be between {min} to {max} characters!")
	private String message;
	
	@Column(name = "date_time")
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date date_time;
	
	
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enquiry(long id, String name, String email, String subject, String message, Date dateTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.date_time = date_time;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getDate_Time() {
		return date_time;
	}
	
	public void setDate_Time(Date date_time) {
		this.date_time = date_time;
	}
	
	
}
