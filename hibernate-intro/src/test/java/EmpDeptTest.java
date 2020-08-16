import java.util.List;

import org.junit.Test;

import com.lti.entity.Dept;
import com.lti.entity.Emp;
import com.lti.entity.dao.GenericDao;

public class EmpDeptTest {
	
	@Test
	public void addDept() {
		Dept d = new Dept();
		d.setDeptno(01);
		d.setLocation("Mahape");
		d.setName("Java");
		
		new GenericDao().save(d);
	}
	
	@Test
	public void addEmps() {
		GenericDao dao = new GenericDao();
		Dept d = dao.fetch(Dept.class, 01);
		
		Emp e1 = new Emp();
		e1.setName("gautam");
		e1.setDept(d);
		e1.setEmpno(007);
		e1.setSalary(34000);
		dao.save(e1);
		
	}
	
	
	@Test
	public void fetchDept() {
		
		GenericDao dao = new GenericDao();
		Dept d = dao.fetch(Dept.class, 01);
		System.out.println(d.getName()+" "+ d.getLocation());
		List<Emp> emps = d.getEmps();
		for(Emp emp: emps)
			System.out.println(emp.getEmpno()+" "+emp.getName()+" "+emp.getSalary());
			
	}
	
	
	@Test
	public void fetchEmp() {

		GenericDao dao = new GenericDao();
		Emp e = dao.fetch(Emp.class, 001);
		System.out.println(e.getName() + " " + e.getSalary());
		Dept d = e.getDept();
		System.out.println(d.getDeptno()+ " " + d.getName()+" "+d.getLocation());

	}

}
