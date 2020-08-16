package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.entity.dao.AccountDao;
import com.lti.entity.dao.GenericDao;

public class AccountService {
	
	public void openAccount(Account account) {
		AccountDao dao = new AccountDao();
		dao.save(account);
	}
	
	public void withdraw(int accno, double amount) {
		//balance should get updated in account and new record inserted in tranc tbl
		AccountDao dao = new AccountDao(); 	
		Account acc = dao.fetch(Account.class, accno);
		acc.setBalance(acc.getBalance()-amount);
		dao.save(acc);
		
		Transaction tx = new Transaction();
		tx.setAccount(acc);
		tx.setTimeAndDate(LocalDateTime.now());
		tx.setAmount(amount);
		tx.setType("Withdraw");
		dao.save(tx);
		
	}
	
	public void deposit(int accno, double amount) {
		
		AccountDao dao = new AccountDao(); 	
		Account acc = dao.fetch(Account.class, accno);
		acc.setBalance(acc.getBalance()+amount);
		dao.save(acc);
		
		Transaction tx = new Transaction();
		tx.setAccount(acc);
		tx.setTimeAndDate(LocalDateTime.now());
		tx.setAmount(amount);
		tx.setType("Withdraw");
		dao.save(tx);
	}
	
	public void transfer (int fromAccno, int toAccno, double amount) {
		
		withdraw(fromAccno, amount);
		deposit(toAccno, amount);
	}
	
	public double balance(int accno) {
		
		AccountDao dao = new AccountDao(); 	
		Account acc = dao.fetch(Account.class, accno);
		
		return acc.getBalance();
	}
	
	public List<Transaction> ministatement(int accno) {
			AccountDao dao = new AccountDao();
			List<Transaction> list = dao.fetchMiniStatement(accno);
			return list;
	}


}
