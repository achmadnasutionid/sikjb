package com.sikjb.controller;

import com.sikjb.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.service.ReportService;

@Controller
public class ReportController {
	
private ReportService reportService;
	
	@Autowired
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@RequestMapping("/report")
	public String ReportList(Model model) {
		model.addAttribute("report", reportService.listReport());
		return "list/report";
	}
	
	@RequestMapping(value = "/report/create", method = RequestMethod.GET)
	public String showFormReport(Model model) {
		model.addAttribute("report", new Report());
		return "form/formReport";
	}	
	
	@RequestMapping(value = "/report/create", method = RequestMethod.POST)
	public String saveFormReport(Model model, Report report) {
			model.addAttribute("report", reportService.saveOrUpdate(report));
			return "redirect:/report";
	}
	
	@RequestMapping(value = "/report/edit/{reportId}", method = RequestMethod.GET)
	public String showFormEditReport(@PathVariable Long reportId, Model model) {
			model.addAttribute("report", reportService.getReportById(reportId));
			return "form/formReport";
	}
	
	@RequestMapping(value = "/report/delete/{reportId}", method = RequestMethod.GET)
	public String deleteReport(@PathVariable Long reportId) {
		reportService.deleteReport(reportId);
			return "redirect:/report";
}
}

