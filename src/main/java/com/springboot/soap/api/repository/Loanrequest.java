package com.springboot.soap.api.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loanrequests_tbl")
public class Loanrequest {
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getYearlyIncome() {
		return yearlyIncome;
	}
	public void setYearlyIncome(long yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}
	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public String getEmploymentMode() {
		return employmentMode;
	}
	public void setEmploymentMode(String employmentMode) {
		this.employmentMode = employmentMode;
	}
	
	@Id
	@GeneratedValue
	private int loanId;
	private String customerName;
    private int age;
    private long yearlyIncome;
    private int cibilScore;
    private String employmentMode;
    
    private boolean isEligible;

	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public boolean isEligible() {
		return isEligible;
	}
	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

}
