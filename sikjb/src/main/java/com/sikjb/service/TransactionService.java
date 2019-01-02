package com.sikjb.service;

import java.util.List;

import com.sikjb.model.Transaction;

public interface TransactionService {
	
	 List<Transaction> listTransaction();

	 Transaction saveOrUpdate(Transaction transaction);

	 Transaction getTransactionById(Long transactionId);
	 
	 void deleteTransactionById(Long transactionId);

	 List<Transaction> listTransactionForReport(String firstDate, String lastDate);
}
