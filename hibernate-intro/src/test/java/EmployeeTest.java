import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.Employee;
import com.lti.entity.dao.CustomerDao;
import com.lti.entity.dao.EmployeeDao;

public class EmployeeTest {
	
	@Test
	public void addEmployee() {
		Employee emp = new Employee();
		emp.setName("Animesh");
		emp.setDateofjoining(LocalDate.parse("2020-06-17"));
		emp.setSalary(38000);
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
	}
	
	@Test
	public void updateEmployee() {
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.fetch(109);
		emp.setName("Nihal");
		dao.update(emp);
		
	}
	
	@Test
	public void fetchAll() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchAll();
		for(Employee e : list)
			System.out.println(e.getPsno()+" " + e.getName()+" "+e.getSalary() );
	}
	
	@Test
	public void fetchByPsno() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchByPsno(107);
		for(Employee e : list)
			System.out.println(e.getPsno()+" " + e.getName()+" "+e.getSalary());
	}
	
	@Test
	public void fetchBySalary() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchBySalary(34000);
		for(Employee e : list)
			System.out.println(e.getPsno()+" " + e.getName()+" "+e.getSalary());
	}
	
	@Test
	public void fetchByjoiningYear() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchByjoiningYear(2020);
		for(Employee e : list)
			System.out.println(e.getPsno()+" " + e.getName()+" "+e.getSalary());
	}
	

}
