package com.sikjb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.sikjb.model.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikjb.service.CashierService;

@Service
public class CashierDao implements CashierService {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Cashier saveOrUpdate(Cashier cashier) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Cashier saved = em.merge(cashier);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void deleteCashier(Long cashierId) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Cashier.class, cashierId));
		em.getTransaction().commit();
	}
	
	@Override
	public Cashier getCashierById(Long cashierId) {
		
		EntityManager em = emf.createEntityManager();
		return em.find(Cashier.class, cashierId);
	}
	
	@Override
	public List<Cashier> listCashier (){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Cashier", Cashier.class) .getResultList();
	}
}