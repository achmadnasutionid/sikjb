package com.sikjb.controller;

import com.sikjb.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.Transaction;
import com.sikjb.service.TransactionService;

@Controller
public class TransactionController {
		
		private TransactionService transactionService;

		private InventoryService inventoryService;

		@Autowired
		public void setInventoryService(InventoryService inventoryService) {
			this.inventoryService = inventoryService;
		}
		
		@Autowired
		public void setTransactionService(TransactionService transactionService) {
			this.transactionService = transactionService;
		}
		
		@RequestMapping("/transaction")
		public String showTransactionList(Model model) {
			model.addAttribute("transaction", transactionService.listTransaction());
			return "list/transaction";
		}

		@RequestMapping(value = "/transaction/create/{inventoryId}", method = RequestMethod.GET)
		public String showFormTransaction(Model model, @PathVariable Long inventoryId) {
			model.addAttribute("transaction", new Transaction());
			model.addAttribute("inventory", inventoryService.getInventoryById(inventoryId));
			return "form/formTransaction";
		}
		
		@RequestMapping(value = "/transaction/create", method = RequestMethod.POST)
		public String saveFormTransaction(Model model, Transaction transaction) {
				model.addAttribute("transaction", transactionService.saveOrUpdate(transaction));
				return "redirect:/transaction";
		}
		
		@RequestMapping(value = "/transaction/edit/{transactionId}", method = RequestMethod.GET)
		public String showFormEditTransaction(@PathVariable Long transactionId, Model model) {
				model.addAttribute("transaction", transactionService.getTransactionById(transactionId));
				return "form/formTransaction";
		}
		
		@RequestMapping(value = "/transaction/delete/{transactionId}", method = RequestMethod.GET)
		public String deleteOneTransaction(@PathVariable Long transactionId) {
			transactionService.deleteTransactionById(transactionId);
				return "redirect:/transaction";
		}
}


