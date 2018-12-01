package com.sikjb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.Inventory;
import com.sikjb.services.InventoryService;

@Controller
public class InventoryContoller {

	
		
		private InventoryService inventoryService;
		
		@Autowired
		public void setInventoryService(InventoryService inventoryService) {
			this.inventoryService = inventoryService;
		}
		  
		
		@RequestMapping("/inventory")
		public String InventoryList(Model model) {
			model.addAttribute("inventory", inventoryService.listInventory());
			return "inventory";
		}
		
		@RequestMapping(value = "/inventory/create", method = RequestMethod.GET)
		public String tampilkanForm(Model model) {
			model.addAttribute("inventory", new Inventory());
			return "FormInventory";
		}
		
		@RequestMapping(value = "/inventory/create", method = RequestMethod.POST)
		public String simpanDataInventory(Model model, Inventory inventory) {
			model.addAttribute("inventory", inventoryService.saveOrUpdate(inventory));
			return "redirect:/Inventory";
		}
		
		@RequestMapping(value = "/inventory/edit/{id}", method = RequestMethod.GET)
		public String editInventory(@PathVariable Integer id, Model model) {
			model.addAttribute("inventory",inventoryService.getId(id));
			return "FormInventory";
		}
		
		@RequestMapping(value = "/inventory/hapus/{id}", method = RequestMethod.GET)
		public String hapusinventory(@PathVariable Integer id) {
			inventoryService.hapusInventory(id);
			return "redirect:/Inventory";
		}
}
