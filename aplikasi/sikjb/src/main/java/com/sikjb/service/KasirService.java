package com.sikjb.service;

import java.util.List;

import com.sikjb.model.Kasir;

public interface KasirService {
	
	List<Kasir> listKasir();
	
	Kasir saveOrUpdate(Kasir kasir);
	
	Kasir getKasirById(Long kasirId);
	
	void deleteKasir(Long kasirId);

}