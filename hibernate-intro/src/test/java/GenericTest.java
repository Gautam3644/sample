import java.time.LocalDate;
import org.junit.Test;
import com.lti.entity.Passport;
import com.lti.entity.Person;
import com.lti.entity.dao.CustomerDao;
import com.lti.entity.dao.GenericDao;


public class GenericTest {

	@Test
	public void addPerson() {
		
		Person person = new Person();
		person.setName("gautam");
		person.setDob(LocalDate.of(1999,12,12));
		
		GenericDao dao = new GenericDao();
		dao.save(person);
	}
	
	@Test
	public void addPassport() {
		Passport passport = new Passport();
		passport.setPassno(3333);
		passport.setCity("Dehradun");
		passport.setIssuedate(LocalDate.of(2020,04,04));
		passport.setExpiredate(LocalDate.of(2030,04,04));
	
		GenericDao dao = new GenericDao();
		dao.save(passport);
	}
	
	@Test
	public void fetchPerson() {
		GenericDao dao = new GenericDao();
		Person person = (Person) dao.fetch(Person.class, 123);

		System.out.print(person.getId() + " " + person.getName() + " " + person.getDob());
		Passport passport = person.getPassport();
		System.out.println(" " + passport.getPassno() + " " + passport.getCity() + " " + passport.getExpiredate()+" "+ passport.getIssuedate());
	}

	@Test
	public void updatePassport() {
		GenericDao dao = new GenericDao();
		Passport passport = (Passport)dao.fetch(Passport.class, 1111);
		passport.setPassno(2222);
		dao.save(passport);
		
	}
	
	/*@Test
	public void updatePerson() {
		GenericDao dao = new GenericDao();
		Person person = (Person)dao.fetch(Person.class, 123);
		person.setDob(LocalDate.of(1998,12,12));
		dao.update(person);
		
	}*/
	
	
	@Test
	public void addPersonAndPassportTogether() {
		Person person = new Person();
		person.setName("Ashish");
		person.setDob(LocalDate.of(1999, 9, 9)); 
		
		Passport passport = new Passport();
		passport.setPassno(3333);
		passport.setCity("Dehradun");
		passport.setIssuedate(LocalDate.of(2020,04,04));
		passport.setExpiredate(LocalDate.of(2030,04,04));
		
		person.setPassport(passport);
		passport.setPerson(person);
		
		GenericDao dao = new GenericDao();
		dao.save(passport);
	}
	
	
	@Test
	public void updatePassportDetails() {
		
	}
	
	@Test
	public void fetchPassportExpiredPeople() {
		
	}
	
	@Test
	public void fetchNameAndPassportNo() {
		
	}
	
}
