package com.sikjb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikjb.model.User;
import com.sikjb.service.UserService;



@Service
public class UserDao implements UserService {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public User saveOrUpdate(User user) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User saved = em.merge(user);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void deleteUser(String userUsername) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(User.class, userUsername));
		em.getTransaction().commit();
	}
	
	@Override
	public User getUserByUsername(String userUsername) {
		
		EntityManager em = emf.createEntityManager();
		return em.find(User.class, userUsername);
	}
	
	@Override
	public List<User> listUser (){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from User", User.class) .getResultList();
	}
}