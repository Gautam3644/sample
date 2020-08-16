

import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.dao.CustomerDao;

public class CustomerTest {
	
	@Test
	public void addCustomer() {
		Customer cust = new Customer();
		cust.setName("ashish");
		cust.setEmail("ashish@lti");
		
		CustomerDao dao = new CustomerDao();
		dao.add(cust);
	}
	
	@Test
	public void fetchCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.fetch(1);
		System.out.println(cust.getName()+" " +cust.getEmail());
	}
	
	@Test
	public void updateCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.fetch(1);
		cust.setEmail("gautam@email");
		dao.update(cust);
		
	}
	
	@Test
	public void fetchAll() {
		CustomerDao dao = new CustomerDao();
		List<Customer> list = dao.fetchAll();
		for(Customer c : list)
			System.out.println(c.getId()+" " + c.getName()+" "+c.getEmail() );
	}
	
	@Test
	public void fetchByEmail() {
		CustomerDao dao = new CustomerDao();
		List<Customer> list = dao.fetch("lti");
		for(Customer c : list)
			System.out.println(c.getId()+" " + c.getName()+" "+c.getEmail());
	}

}
