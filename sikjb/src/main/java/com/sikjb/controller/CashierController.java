package com.sikjb.controller;


import com.sikjb.model.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.service.CashierService;

@Controller
public class CashierController {
	
	private CashierService cashierService;
	
	@Autowired
	public void setCashierService(CashierService cashierService) {
		this.cashierService = cashierService;
	}
	
	@RequestMapping("/cashier")
	public String showCashierList(Model model) {
		model.addAttribute("cashier", cashierService.listCashier());
		return "list/cashier";
	}
	
	@RequestMapping(value = "/cashier/create", method = RequestMethod.GET)
	public String showFormCashier(Model model) {
		model.addAttribute("cashier", new Cashier());
		return "form/formCashier";
	}	
	
	@RequestMapping(value = "/cashier/create", method = RequestMethod.POST)
	public String saveFormCashier(Model model, Cashier cashier) {
			model.addAttribute("cashier", cashierService.saveOrUpdate(cashier));
			return "redirect:/cashier";
	}
	
	@RequestMapping(value = "/cashier/edit/{Id}", method = RequestMethod.GET)
	public String showFormEditCashier(@PathVariable Long Id, Model model) {
			model.addAttribute("cashier", cashierService.getCashierById(Id));
			return "form/formCashier";
	}
	
	@RequestMapping(value = "/cashier/delete/{Id}", method = RequestMethod.GET)
	public String deleteOneCashier(@PathVariable Long Id) {
			cashierService.deleteCashierById(Id);
			return "redirect:/cashier";
}
}