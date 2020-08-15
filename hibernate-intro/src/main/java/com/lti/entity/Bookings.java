package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bookings")
public class Bookings {
	
	@Id
	private int bookid;
	
	private LocalDate date;
	private int tracid;
	//passengers details are missing 
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTracid() {
		return tracid;
	}
	public void setTracid(int tracid) {
		this.tracid = tracid;
	} 
	
	

}
