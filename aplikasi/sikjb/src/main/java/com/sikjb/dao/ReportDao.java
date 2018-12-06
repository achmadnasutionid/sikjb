package com.sikjb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.sikjb.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikjb.service.ReportService;

@Service
public class ReportDao implements ReportService{
	
private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Report saveOrUpdate(Report report) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Report saved = em.merge(report);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void deleteReport(Long reportId) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Report.class, reportId));
		em.getTransaction().commit();
	}
	
	@Override
	public Report getReportById(Long reportId) {
		
		EntityManager em = emf.createEntityManager();
		return em.find(Report.class, reportId);
	}
	
	@Override
	public List<Report> listReport (){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Report", Report.class) .getResultList();
	}

}
