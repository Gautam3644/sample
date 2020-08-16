package com.lti.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.profile.Fetch;

@Entity
@Table (name="TBL_DEPT")
public class Dept {
	
	
	@Id
	private int deptno;
	
	private String name;
	private String location;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	private List<Emp> emps;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	
}
