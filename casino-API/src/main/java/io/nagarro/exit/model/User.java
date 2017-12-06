package io.nagarro.exit.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private Date dob;
	private String contactNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getSecretID() {
		return secretID;
	}

	public void setSecretID(Long secretID) {
		this.secretID = secretID;
	}

	public User(int id, String name, Date dob, String contactNo, String emailId, String identityFilePath,
			Double accountBal, int blockedAmount, Long secretID) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.identityFilePath = identityFilePath;
		this.accountBal = (double) 0L;
		this.blockedAmount = 0;
	}

	public Double getAccountBal() {
		return accountBal;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAccountBal(Double accountBal) {
		this.accountBal = accountBal;
	}

	public int getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(int blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	public String getIdentityFilePath() {
		return identityFilePath;
	}

	public void setIdentityFilePath(String identityFilePath) {
		this.identityFilePath = identityFilePath;
	}

	private String emailId;
	private String identityFilePath;
	private Double accountBal;
	private int blockedAmount;
	private Long secretID;

}
