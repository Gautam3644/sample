package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rtschedule")
public class RouteSchedule {

	@Id
	private int sid;
	private LocalDate date;
	private LocalTime depttime;
	private LocalTime arrtime;
	
	//routeid
	//a route can have many no of flightschedules
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getDepttime() {
		return depttime;
	}
	public void setDepttime(LocalTime depttime) {
		this.depttime = depttime;
	}
	public LocalTime getArrtime() {
		return arrtime;
	}
	public void setArrtime(LocalTime arrtime) {
		this.arrtime = arrtime;
	}
	
	
}
