package com.finastra.springdemo.dao1;

import com.finastra.springdemo.entity.Deposit;
import com.finastra.springdemo.entity.Login;
import com.finastra.springdemo.entity.Users;
import com.finastra.springdemo.entity.Withdraw;

public interface BankDao {

public	void deposit(Deposit de);
//public boolean validateLogin(int userId,String password);
//public void register();
public void register(Users users);
public boolean validateLogin(Login login);
public void withdraw(Withdraw w);
public boolean transfer(int from_Account, int to_Account, double amount);
	
	

}
