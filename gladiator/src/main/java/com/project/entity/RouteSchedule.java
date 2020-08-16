package com.project.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rschedule")
public class RouteSchedule {

	@Id
	private int sid;
	
	private LocalDate date;
	private LocalTime depttime;
	private LocalTime arrtime;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	@OneToOne(mappedBy = "routeschedule")
	private FlightSchedule flightschedule;
	
	
	public FlightSchedule getFlightschedule() {
		return flightschedule;
	}
	public void setFlightschedule(FlightSchedule flightschedule) {
		this.flightschedule = flightschedule;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
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
