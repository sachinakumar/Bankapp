package com.finastra.springdemo.dao1;

import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finastra.springdemo.entity.BankAccount;
import com.finastra.springdemo.entity.Deposit;
import com.finastra.springdemo.entity.Login;
import com.finastra.springdemo.entity.Transfer;
import com.finastra.springdemo.entity.Users;
import com.finastra.springdemo.entity.Withdraw;

@Repository
public class BankDaoImpl implements BankDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void deposit(Deposit de) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(de);
		double balance = checkBalance(de.getUserId());

		updateBalance(de.getUserId(), balance + de.getAmount());

	}

	@Transactional
	@Override
	public void register(Users users) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(users);

	}

	@Override
	public boolean validateLogin(Login login) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query thequery = currentSession.createQuery("from Users where userid=:user,password=:password ", Users.class);
		thequery.setParameter("user", login.getUserId());
		thequery.setParameter("password", login.getPassword());
		List<Users> users = thequery.getResultList();
		if (null != users && users.size() != 0) {
			// Users user = users.get(0);
			return true;
		}

		return false;
	}

	@Override
	@Transactional
	public void withdraw(Withdraw w) {
		// TODO Auto-generated method stub
		double bal = checkBalance(w.getUserId());
		if (bal >= w.getAmount()) {

			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(w);
			int userid = w.getUserId();
			double amt = w.getAmount();
			updateBalance(userid, bal - amt);

		} else {
			System.out.println("balance is not sufficient");
		}
	}

	@Transactional
	public double checkBalance(int userId) {
		// TODO Auto-generated method stub
		double balance = 0;
		try {

			Session currentSession = sessionFactory.getCurrentSession();
			Query thequery = currentSession.createQuery("from BankAccount u where u.userid = :username",
					BankAccount.class);
			// select b.balance from BankAccount b where b.userid=:userd

			thequery.setParameter("username", userId);
			BankAccount ac = (BankAccount) thequery.getResultList().get(0);
			balance = ac.getBalance();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("printing stack trace");
			e.printStackTrace();
		}
		return balance;
	}

	@Transactional
	public void updateBalance(int userid, double balance) {
		// TODO Auto-generated method stub
		// BankAccount ba = new BankAccount();
		Session currentSession = sessionFactory.getCurrentSession();
		Query thequery = currentSession.createQuery("from BankAccount u where u.userid = :username", BankAccount.class);
		// select b.balance from BankAccount b where b.userid=:userd

		thequery.setParameter("username", userid);
		BankAccount ac = (BankAccount) thequery.getResultList().get(0);
		ac.setUserid(userid);
		ac.setBalance(balance);

		currentSession.saveOrUpdate(ac);

		/*
		 * Query thequery = currentSession.
		 * createQuery("update BankAccount set balance=:balance where userId=:userid",
		 * BankAccount.class); thequery.setParameter("userid", userid);
		 * thequery.setParameter("balance", balance); currentSession.u // return false;
		 */
	}

	@Transactional
	public boolean transfer(int from, int to, double amt) {
		try {
			Withdraw w = new Withdraw();

			w.setAmount(amt);
			w.setUserId(from);

			withdraw(w);
			Deposit d = new Deposit();
			d.setAmount(amt);
			d.setUserId(to);
			deposit(d);
			Transfer t = new Transfer();
			t.setAmount(amt);
			t.setFrom_Account(from);
			t.setTo_Account(to);
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(t);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

}
