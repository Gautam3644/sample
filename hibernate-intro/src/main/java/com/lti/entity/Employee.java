package com.lti.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMP")
public class Employee {
	
	@Id
	@GeneratedValue
	private int psno;
	
	private String name;
	private LocalDate dateofjoining;
	private double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id")//fk column -->pk column
	private Address address;//has-a
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public int getPsno() {
		return psno;
	}
	public void setPsno(int psno) {
		this.psno = psno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
