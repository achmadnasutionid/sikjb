package com.sikjb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikjb.model.Kasir;
import com.sikjb.service.KasirService;

@Service
public class KasirDao implements KasirService {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Kasir saveOrUpdate(Kasir kasir) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kasir saved = em.merge(kasir);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void deleteKasir(Long kasirId) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Kasir.class, kasirId));
		em.getTransaction().commit();
	}
	
	@Override
	public Kasir getKasirById(Long kasirId) {
		
		EntityManager em = emf.createEntityManager();
		return em.find(Kasir.class, kasirId);
	}
	
	@Override
	public List<Kasir> listKasir (){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Kasir", Kasir.class) .getResultList();
	}
}