package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Enquiry;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry,Long> {

	Enquiry findByEmail(String email);
}
