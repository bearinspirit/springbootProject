package com.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="mail")
public class Mail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	@NotNull(message = "Email cannot be empty!")
	private String email;
	
	@Column(name = "subject")
	@NotNull(message = "Subject cannot be empty!")
	@Size(min=5, max=50, message = "Subject must be between {min} to {max} characters!")
	private String subject;
	
	@Column(name = "admin_reply")
	@NotNull(message = "Message cannot be empty!")
	@Size(min=10, max=2000, message = "Message must be between {min} to {max} characters!")
	private String admin_reply;
	
	@Column(name = "date_time")
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date date_time;

	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mail(long id, String name, String email, String subject, String admin_reply, Date date_time) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.admin_reply = admin_reply;
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

	public String getAdmin_Reply() {
		return admin_reply;
	}

	public void setAdminReply(String admin_reply) {
		this.admin_reply = admin_reply;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

}	