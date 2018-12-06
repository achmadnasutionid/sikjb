package com.sikjb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikjb.model.Role;
import com.sikjb.service.RoleService;

@Service
public class RoleDao implements RoleService {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public Role saveOrUpdate(Role role) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Role saved = em.merge(role);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void deleteRole(Long roleId) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Role.class, roleId));
		em.getTransaction().commit();
	}
	
	@Override
	public Role getRoleById(Long roleId) {
		
		EntityManager em = emf.createEntityManager();
		return em.find(Role.class, roleId);
	}
	
	@Override
	public List<Role> listRole (){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Role", Role.class) .getResultList();
	}
}