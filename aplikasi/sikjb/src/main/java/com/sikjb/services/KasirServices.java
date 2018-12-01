package com.sikjb.services;

import java.util.List;

import com.sikjb.model.Kasir;

public interface KasirServices {
	
	List<Kasir> listKasir();
	
	
	Kasir saveOrUpdate(Kasir kasir);
	
	Kasir getKasirById(Long kasirId);
	
	void deleteKasir(Long kasirId);

}