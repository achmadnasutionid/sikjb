package com.sikjb.service;

import java.util.List;

import com.sikjb.model.Report;

public interface ReportService {

	List<Report> listReport();
	
	Report saveOrUpdate(Report report);
	
	Report getReportById(Long reportId);
	
	void deleteReport(Long reportId);
}
