package com.lti.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ACT")
public class Account {

	@Id
	@GeneratedValue
	private int accno;
	private String name;
	
	@Column(name = "ac_type")
	private String type;
	private double balance;
	
	@OneToMany(mappedBy="account")
	private List<Transaction> transaction;


	public int getAccno() {
		return accno;
	}


	public void setAccno(int accno) {
		this.accno = accno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAcctype() {
		return type;
	}


	public void setAcctype(String acctype) {
		this.type = acctype;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
