package com.sikjb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.Inventory;
import com.sikjb.service.InventoryService;

@Controller
public class InventoryContoller {
		
		private InventoryService inventoryService;
		
		@Autowired
		public void setInventoryService(InventoryService inventoryService) {
			this.inventoryService = inventoryService;
		}
		  
		
		@RequestMapping("/inventory")
		public String showInventoryList(Model model) {
			model.addAttribute("inventory", inventoryService.listInventory());
			return "list/inventory";
		}
		
		@RequestMapping(value = "/inventory/create", method = RequestMethod.GET)
		public String showFormInventory(Model model) {
			model.addAttribute("inventory", new Inventory());
			return "form/formInventory";
		}
		
		@RequestMapping(value = "/inventory/create", method = RequestMethod.POST)
		public String saveFormInventory(Model model, Inventory inventory) {
			model.addAttribute("inventory", inventoryService.saveOrUpdate(inventory));
			return "redirect:/inventory";
		}
		
		@RequestMapping(value = "/inventory/edit/{inventoryId}", method = RequestMethod.GET)
		public String showFormEditInventory(@PathVariable Long inventoryId, Model model) {
			model.addAttribute("inventory",inventoryService.getInventoryById(inventoryId));
			return "form/formInventory";
		}
		
		@RequestMapping(value = "/inventory/delete/{inventoryId}", method = RequestMethod.GET)
		public String deleteOneInventory(@PathVariable Long inventoryId) {
			inventoryService.deleteInventoryById(inventoryId);
			return "redirect:/inventory";
		}
}
