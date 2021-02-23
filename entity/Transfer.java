package com.finastra.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfer")
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "from_Account")
	private int from_Account;
	@Column(name = "to_Account")
	private int to_Account;
	@Column(name = "amount")
	private double amount;

	public Transfer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrom_Account() {
		return from_Account;
	}

	public void setFrom_Account(int from_Account) {
		this.from_Account = from_Account;
	}

	public int getTo_Account() {
		return to_Account;
	}

	public void setTo_Account(int to_Account) {
		this.to_Account = to_Account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
