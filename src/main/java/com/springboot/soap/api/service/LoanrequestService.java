package com.springboot.soap.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.soap.api.repository.Loanrequest;
import com.springboot.soap.api.repository.LoanrequestRepository;

@Service
public class LoanrequestService {
	
	@Autowired
	LoanrequestRepository loanrequestRepository;
	
	public String saveLoanRequest(Loanrequest request) {
		loanrequestRepository.save(request);
		
		return "Data saved successfully.";
	}
	
	

}
