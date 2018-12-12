package com.sikjb.service;

import java.util.List;

import com.sikjb.model.Cashier;

public interface CashierService {
	
	List<Cashier> listCashier();
	
	Cashier saveOrUpdate(Cashier cashier);
	
	Cashier getCashierById(Long cashierId);
	
	void deleteCashierById(Long cashierId);

}