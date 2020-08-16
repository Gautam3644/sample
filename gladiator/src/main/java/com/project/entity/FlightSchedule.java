package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FlightSchedule")
public class FlightSchedule {

	@Id
	private int fsid;
	private int ecoprice;
	private int bussprice;
	private int availableseats;
	
    @OneToOne
    @JoinColumn(name="flightschedule_sid")
    private RouteSchedule routeschedule;
	
    @OneToOne
    @JoinColumn(name ="flights_fid")
    private Flights flights;
    
	public Flights getFlights() {
		return flights;
	}
	public void setFlights(Flights flights) {
		this.flights = flights;
	}
	public RouteSchedule getRouteschedule() {
		return routeschedule;
	}
	public void setRouteschedule(RouteSchedule routeschedule) {
		this.routeschedule = routeschedule;
	}
	public int getFsid() {
		return fsid;
	}
	public void setFsid(int fsid) {
		this.fsid = fsid;
	}
	public int getEcoprice() {
		return ecoprice;
	}
	public void setEcoprice(int ecoprice) {
		this.ecoprice = ecoprice;
	}
	public int getBussprice() {
		return bussprice;
	}
	public void setBussprice(int bussprice) {
		this.bussprice = bussprice;
	}
	public int getAvailableseats() {
		return availableseats;
	}
	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}
}
