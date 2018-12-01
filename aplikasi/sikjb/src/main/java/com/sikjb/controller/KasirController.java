package com.sikjb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.Kasir;
import com.sikjb.service.KasirService;

@Controller
public class KasirController {
	
	private KasirService kasirService;
	
	@Autowired
	public void setKasirService(KasirService kasirService) {
		this.kasirService = kasirService;
	}
	
	@RequestMapping("/kasir")
	public String KasirList(Model model) {
		model.addAttribute("kasir", kasirService.listKasir());
		return "list/kasir";
	}
	
	@RequestMapping(value = "/kasir/create", method = RequestMethod.GET)
	public String showFormKasir(Model model) {
		model.addAttribute("kasir", new Kasir());
		return "form/formKasir";
	}	
	
	@RequestMapping(value = "/kasir/create", method = RequestMethod.POST)
	public String saveFormKasir(Model model, Kasir kasir) {
			model.addAttribute("kasir", kasirService.saveOrUpdate(kasir));
			return "redirect:/kasir";
	}
	
	@RequestMapping(value = "/kasir/edit/{kasirId}", method = RequestMethod.GET)
	public String showFormEditKasir(@PathVariable Long kasirId, Model model) {
			model.addAttribute("kasir", kasirService.getKasirById(kasirId));
			return "form/formKasir";
	}
	
	@RequestMapping(value = "/kasir/delete/{kasirId}", method = RequestMethod.GET)
	public String deleteKasir(@PathVariable Long kasirId) {
			kasirService.deleteKasir(kasirId);
			return "redirect:/kasir";
}
}