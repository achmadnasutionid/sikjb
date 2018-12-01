package com.sikjb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.Kasir;
import com.sikjb.services.KasirServices;

@Controller
public class KasirController {
	
	private KasirServices kasirServices;
	
	@Autowired
	public void setKasirServices(KasirServices kasirServices) {
		this.kasirServices = kasirServices;
	}
	
	@RequestMapping("/kasir")
	public String KasirList(Model model) {
		model.addAttribute("kasir", kasirServices.listKasir());
		return "kasir";	
	}
	
	@RequestMapping(value = "/kasir/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("kasir", new Kasir());
		return "formKasir";
	}	
	
	@RequestMapping(value = "/kasir/create", method = RequestMethod.POST)
	public String simpanDataKasir(Model model, Kasir kasir) {
			model.addAttribute("kasir", kasirServices.saveOrUpdate(kasir));
			return "redirect:/kasir";
	}
	
	@RequestMapping(value = "/kasir/edit/{kasirId}", method = RequestMethod.GET)
	public String editKasir(@PathVariable Long kasirId, Model model) {
			model.addAttribute("kasir", kasirServices.getKasirById(kasirId));
			return "formKasir";
	}
	
	@RequestMapping(value = "/kasir/delete/{id}", method = RequestMethod.GET)
	public String deleteKasir(@PathVariable Long KasirId) {
			kasirServices.deleteKasir(KasirId);
			return "redirect:/kasir";
}
}