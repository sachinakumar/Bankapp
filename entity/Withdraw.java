package com.finastra.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="withdraw")
public class Withdraw {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int withdrawnid;
	
	@Column(name="userId")
	private int userId;
	@Column(name="amount")
	private double amount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Withdraw() {
		super();
	}
}
