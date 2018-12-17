package com.sikjb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.sikjb.model.Inventory;
import com.sikjb.service.InventoryService;

@Service
public class InventoryDao implements InventoryService {

	private EntityManagerFactory emf;
		
		@Autowired
		public void setEmf(EntityManagerFactory emf) {
			this.emf = emf;
		}
		
		@Override
		public List<Inventory> listInventory(){
			EntityManager em = emf.createEntityManager();
			return em.createQuery("from Inventory", Inventory.class) .getResultList();
		}
		
		@Override
		@PreAuthorize("hasRole('ROLE_CASHIER')")
		public Inventory saveOrUpdate(Inventory inventory) {
			
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Inventory saved = em.merge(inventory);
			em.getTransaction().commit();
			return saved;
		}
		
		@Override
		@PreAuthorize("hasRole('ROLE_CASHIER')")
		public void deleteInventoryById(Long inventoryId) {
			
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Inventory.class, inventoryId));
			em.getTransaction().commit();
		}
		
		@Override
		public Inventory getInventoryById(Long inventoryId) {
			
			EntityManager em = emf.createEntityManager();
			return em.find(Inventory.class,inventoryId);
		}
}
