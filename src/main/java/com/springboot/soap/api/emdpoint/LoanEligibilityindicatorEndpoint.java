package com.springboot.soap.api.emdpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//import com.springboot.soap.api.loaneligibility.Acknowledgement;
//import com.springboot.soap.api.loaneligibility.CustomerRequest;
import com.springboot.soap.api.repository.Loanrequest;
import com.springboot.soap.api.service.LoanEligibilityService;
import com.springboot.soap.api.service.LoanrequestService;
import com.springboot.spring.soap.api.loaneligibility.Acknowledgement;
import com.springboot.spring.soap.api.loaneligibility.CustomerRequest;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.springboot.com/spring/soap/api/loanEligibility";
	
	@Autowired
	private LoanEligibilityService service;

	@Autowired
	private LoanrequestService loanrequestService;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {

		// SQL code changes for inserting data into the Data Base tables.

		Loanrequest loanreq = new Loanrequest();

		Acknowledgement ack = service.checkLoanEligibility(request);

		//if (ack.isIsEligible()) {
			System.out.println("About to Start executing DB logic");
			loanreq.setCustomerName(request.getCustomerName());
			loanreq.setAge(request.getAge());
			loanreq.setCibilScore(request.getCibilScore());
			loanreq.setYearlyIncome(request.getYearlyIncome());
			loanreq.setEmploymentMode(request.getEmploymentMode());
			
			loanreq.setEligible(ack.isIsEligible());
			
			loanrequestService.saveLoanRequest(loanreq);
			System.out.println("Successfully Executed DB logic");
		//}

		return ack;
	}

}
