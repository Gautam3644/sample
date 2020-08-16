package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_FLIGHTS")
public class Flights {
	
	@Id
	private int fid;
	
	private String airlines;
	private int capacity;
	private int baggage;
	
	//one flight will have different schedules
	@OneToOne(mappedBy = "flights")
	private FlightSchedule flightschedule;
	
	public FlightSchedule getFlightschedule() {
		return flightschedule;
	}
	public void setFlightschedule(FlightSchedule flightschedule) {
		this.flightschedule = flightschedule;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getBaggage() {
		return baggage;
	}
	public void setBaggage(int baggage) {
		this.baggage = baggage;
	}
	
}
