package com.finastra.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.finastra.springdemo.dao1.BankDao;

import com.finastra.springdemo.entity.Deposit;
import com.finastra.springdemo.entity.Login;
import com.finastra.springdemo.entity.Transfer;
import com.finastra.springdemo.entity.Users;
import com.finastra.springdemo.entity.Withdraw;

@Controller
public class BankController {
	@Autowired
	private BankDao bankDao;

	@GetMapping("/home")
	public String home() {
		return "homePage";

	}

	@GetMapping("/register")
	public String register(Model m) {
		Users user = new Users();
		m.addAttribute("reg", user);
		return "registration";
	}

	@PostMapping("/register")
	public String registerProcess(@ModelAttribute("reg") Users users) {
		bankDao.register(users);
		return "redirect:/home";
	}

	@GetMapping("/ExisUser")
	public String login() {
		return "Login";
	}

	@GetMapping("/login")
	public String transactions() {
		// bankDao.validateLogin();
		// if(validateLogin==true) {
		return "transactions";
	}

	@PostMapping("/login")
	public String transactions(Login login) {
		// bankDao.validateLogin(login);
		if (bankDao.validateLogin(login)) {
			return "transactions";
		}
		// if(validateLogin==true) {
		return "Login";
	}

	@PostMapping("/deposit")
	public String deposit(@ModelAttribute("depo") Deposit de) {
		bankDao.deposit(de);
		return "redirect:/login";
	}

	@GetMapping("/deposit")
	public String deposit(Model m) { //
		// bankDao.deposit(de);
		Deposit cu = new Deposit();
		m.addAttribute("depo", cu);
		// bankDao.deposit(cu);
		return "Deposit";
	}

	@GetMapping("/withdraw")
	public String withdraw(Model m) { //
		// bankDao.deposit(de);
		Withdraw w = new Withdraw();
		m.addAttribute("With", w);
		// bankDao.deposit(cu);
		return "Withdraw";
	}

	@PostMapping("/withdraw")
	public String withdraw(@ModelAttribute("With") Withdraw w) {
		bankDao.withdraw(w);
		return "redirect:/home";
	}
	@GetMapping("/transfer")
	public String transfer(Model m) { //
		// bankDao.deposit(de);
		Transfer t = new Transfer();
		m.addAttribute("trans", t);
		// bankDao.deposit(cu);
		return "transfer";
	}
	@PostMapping("/transfer")
	public String withdraw(@ModelAttribute("trans") Transfer t) {
		bankDao.transfer(t.getFrom_Account(),t.getTo_Account(),t.getAmount());
		return "redirect:/home";
	}
	

}
