import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import com.lti.entity.Address;
import com.lti.entity.Employee;
import com.lti.entity.dao.EmployeeDao;

public class EmployeeAddressTest {
	
	@Test
	public void addAnEmployee() {
		Employee emp = new Employee();
		emp.setName("Ashish");
		emp.setDateofjoining(LocalDate.of(2020,06,17));
		emp.setSalary(34000);
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
		
	}
	
	@Test
	public void addAddressForAnExistingEmployee() {
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.fetch(107);
		
		Address addr = new Address();
		addr.setCity("Champawat");
		addr.setPincode(262523);
		addr.setLandmark("Almamater School");
		
		
	}
	
	@Test
	public void addAnEmployeeAlongWithAddress() {
		
		Employee emp = new Employee();
		emp.setName("Anant");
		emp.setDateofjoining(LocalDate.of(2020,07,28));
		emp.setSalary(34000);
		
		Address addr = new Address();
		addr.setCity("Dehradun");
		addr.setPincode(248007);
		addr.setLandmark("Jakhan");
		
		emp.setAddress(addr);
		
		//we want a way by which an employee and address both get saved in the db automatically 
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
		
		//alternatively it can be done by
		//dao.add(addr);
		//dao.add(emp);
	}
	
	@Test
	public void fetchByCity() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchByCity("Dehradun");
		for(Employee e : list)
			System.out.println(e.getPsno()+" " + e.getName()+" "+e.getSalary());

		
	}
}
