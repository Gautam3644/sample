package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {
	
	@Id
	private int id;
	
	private String source;
	private String dest;
	
	@OneToMany(mappedBy="route", cascade = CascadeType.ALL)
	private List<RouteSchedule> routeschedules;
	
	public List<RouteSchedule> getRouteschedules() {
		return routeschedules;
	}
	
	public void setRouteschedules(List<RouteSchedule> routeschedules) {
		this.routeschedules = routeschedules;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsource() {
		return source;
	}
	public void setsource(String source) {
		this.source = source;
	}
	public String getdest() {
		return dest;
	}
	public void setdest(String dest) {
		this.dest = dest;
	}

}
