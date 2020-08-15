package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FlightSchedule")
public class FlightSchedule {

	@Id
	private int fsid;
	private int ecoprice;
	private int bussprice;
	private int availableseats;
	
	//schedule id
	//flightid
	
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
