package com.sikjb.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	
	private Long income;
	
	private Long outcome;
	
	private Date date;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	public Long getOutcome() {
		return outcome;
	}

	public void setOutcome(Long outcome) {
		this.outcome = outcome;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Long inventory_id) {
		this.inventory_id = inventory_id;
	}

	public Integer getInventory_quantity() {
		return inventory_quantity;
	}

	public void setInventory_quantity(Integer inventory_quantity) {
		this.inventory_quantity = inventory_quantity;
	}

	private Long inventory_id;
	
	private Integer inventory_quantity;
	
}
