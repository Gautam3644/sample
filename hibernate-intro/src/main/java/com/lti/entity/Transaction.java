package com.lti.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TRNC")
public class Transaction {

	@Id
	@GeneratedValue
	private int txno;
	
	@Column(name = "date_and_time")
	private LocalDateTime timeAndDate;
	private double amount;
	
	@Column(name="transc_type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name="accno")
	private Account account;

	public int getTxno() {
		return txno;
	}

	public void setTxno(int txno) {
		this.txno = txno;
	}

	public LocalDateTime getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(LocalDateTime timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
