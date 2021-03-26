package com.springboot.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.springboot.soap.api.emdpoint.LoanEligibilityindicatorEndpoint;
//import com.springboot.soap.api.loaneligibility.Acknowledgement;
//import com.springboot.soap.api.loaneligibility.CustomerRequest;
import com.springboot.soap.api.repository.Loanrequest;
import com.springboot.soap.api.repository.LoanrequestRepository;
import com.springboot.soap.api.service.LoanEligibilityService;
import com.springboot.soap.api.service.LoanrequestService;
import com.springboot.spring.soap.api.loaneligibility.Acknowledgement;
import com.springboot.spring.soap.api.loaneligibility.CustomerRequest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootSoapServiceApplicationTests {

	@MockBean
	private LoanEligibilityService service;

	@Autowired
	private LoanEligibilityindicatorEndpoint endpoints;

	@Autowired
	private LoanrequestService loanService;

	@MockBean
	private LoanrequestRepository repo;

	@Test
	public void checkSaveOperations() {

		Loanrequest loanreq = new Loanrequest();
		loanreq.setCustomerName("ABC");
		loanreq.setAge(44);
		loanreq.setCibilScore(789);
		loanreq.setYearlyIncome(200000);
		loanreq.setEmploymentMode("Software");

		loanreq.setEligible(true);

		when(repo.save(loanreq)).thenReturn(loanreq);

		assertEquals("Data saved successfully.", loanService.saveLoanRequest(loanreq));

	}

	@Test
	public void testLoanEligibilityBasedOnInputRequest() {

		CustomerRequest req = new CustomerRequest();

		req.setCustomerName("Abc");
		req.setAge(40);
		req.setCibilScore(760);
		req.setYearlyIncome(200000);
		req.setEmploymentMode("Gove");

		System.out.println("Income :" + req.getYearlyIncome());

		Acknowledgement ack = new Acknowledgement();

		ack.setApprovedAmount(req.getYearlyIncome());

		when(service.checkLoanEligibility(req)).thenReturn(ack);

		assertEquals(ack, endpoints.getLoanStatus(req));

	}

	@Test
	public void testLoanEligibilityBasedOnYearlyIncome() {

		CustomerRequest req = new CustomerRequest();

		req.setCustomerName("Abc");
		req.setAge(4);
		req.setCibilScore(760);
		req.setYearlyIncome(200000);
		req.setEmploymentMode("Gove");

		System.out.println("Income :" + req.getYearlyIncome());

		Acknowledgement ack = new Acknowledgement();

		ack.setApprovedAmount(50000);
		ack.setIsEligible(false);

		when(service.checkLoanEligibility(req)).thenReturn(ack);

		System.out.println(ack.getApprovedAmount());

		assertEquals(req.getYearlyIncome(), endpoints.getLoanStatus(req).getApprovedAmount());

	}

	@Test
	public void testLoanEligibilityBasedOnAge() {

		CustomerRequest req = new CustomerRequest();

		req.setCustomerName("Abc");
		req.setAge(40);
		req.setCibilScore(760);
		req.setYearlyIncome(200000);
		req.setEmploymentMode("Gove");

		System.out.println("Income :" + req.getYearlyIncome());

		Acknowledgement ack = new Acknowledgement();

		ack.setApprovedAmount(200000);
		ack.setIsEligible(false);
		ack.setAge(4);

		when(service.checkLoanEligibility(req)).thenReturn(ack);

		System.out.println(ack.getApprovedAmount());

		assertEquals(req.getAge(), endpoints.getLoanStatus(req).getAge());

	}

	@Test
	public void testLoanEligibilityBasedOnCibilScore() {

		CustomerRequest req = new CustomerRequest();

		req.setCustomerName("Abc");
		req.setAge(4);
		req.setCibilScore(760);
		req.setYearlyIncome(200000);
		req.setEmploymentMode("Gove");

		System.out.println("Income :" + req.getYearlyIncome());

		Acknowledgement ack = new Acknowledgement();

		ack.setApprovedAmount(200000);
		ack.setIsEligible(false);
		ack.setAge(4);

		when(service.checkLoanEligibility(req)).thenReturn(ack);

		System.out.println(ack.getApprovedAmount());

		assertEquals(req.getCibilScore(), endpoints.getLoanStatus(req).getCibilScore());

	}

	@Test
	public void testLoanEligibilityBasedOnEmpMode() {

		CustomerRequest req = new CustomerRequest();

		req.setCustomerName("Abc");
		req.setAge(4);
		req.setCibilScore(760);
		req.setYearlyIncome(200000);
		req.setEmploymentMode("Gove");

		System.out.println("Income :" + req.getYearlyIncome());

		Acknowledgement ack = new Acknowledgement();

		ack.setApprovedAmount(200000);
		ack.setIsEligible(false);

		when(service.checkLoanEligibility(req)).thenReturn(ack);

		System.out.println(ack.getApprovedAmount());

		assertEquals(req.getEmploymentMode(), endpoints.getLoanStatus(req).getEmploymentMode());

	}


}
