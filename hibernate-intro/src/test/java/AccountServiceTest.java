import java.util.List;
import org.junit.Test;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.entity.dao.AccountDao;
import com.lti.service.AccountService;

public class AccountServiceTest {
	
	@Test
	public void openAccount() {
		AccountService acserv = new AccountService();
		
		Account acc = new Account();
		acc.setName("Gautam");
		acc.setAcctype("salary");
		acc.setBalance(33000);
		
		acserv.openAccount(acc);
	}
	
	@Test
	public void withdraw() {
		AccountService acserv = new AccountService();
		acserv.withdraw(135, 1000);
	}
	
	@Test
	public void deposit() {
		AccountService acserv = new AccountService();
		acserv.deposit(135, 5000);
	}
	
	@Test
	public void transfer() {
		AccountService acserv = new AccountService();
		acserv.transfer(239, 235, 5000.00);
	}
	
	@Test
	public void balance() {
		AccountService acserv = new AccountService();
		double balance = acserv.balance(135);
		System.out.println(balance);
	}
	
	@Test
	public void ministatement() {
		//AccountDao acd = new AccountDao();
		AccountService acserv = new AccountService();
		List<Transaction> list = acserv.ministatement(135);
		
		for(Transaction i: list) {
			System.out.println(i.getTxno() + " , " + i.getAmount() + " , " + i.getType() + " , " + i.getTimeAndDate() + " , " +i.getAccount().getAccno());
		}
	}
	
	@Test
	public void updateAccount() {
		AccountDao dao = new AccountDao();
		Account acc = dao.fetch(Account.class, 239);
		acc.setName("Anvesh");
		dao.save(acc);
		
	}

}
