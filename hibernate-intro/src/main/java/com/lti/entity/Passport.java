package com.lti.entity;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PSP")
public class Passport {
	
	@Id
	private int passno;
	private LocalDate issuedate;
	private LocalDate expiredate;
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public int getPassno() {
		return passno;
	}
	public void setPassno(int passno) {
		this.passno = passno;
	}
	public LocalDate getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(LocalDate issuedate) {
		this.issuedate = issuedate;
	}
	public LocalDate getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(LocalDate expiredate) {
		this.expiredate = expiredate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
