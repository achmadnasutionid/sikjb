package com.sikjb.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikjb.model.Transaction;
import com.sikjb.service.TransactionService;

@Service
public class TransactionDao implements TransactionService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Transaction> listTransaction() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Transaction", Transaction.class).getResultList();
    }

    @Override
    public Transaction saveOrUpdate(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Transaction saved = em.merge(transaction);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        EntityManager em = emf.createEntityManager();
		return em.find(Transaction.class, transactionId);
    }

    @Override
    public void deleteTransactionById(Long transactionId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Transaction.class, transactionId));
        em.getTransaction().commit();
    }

    @Override
    public List<Transaction> listTransactionForReport(String firstDate, String lastDate) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Transaction where date>='"+firstDate+"' and date<='"+lastDate+"'", Transaction.class).getResultList();
    }

}
