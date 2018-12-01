package com.sikjb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(generator = "account_generator")
	@SequenceGenerator(name = "account_generator", sequenceName = "account_generator", initialValue = 1)
	private Long Id;
	
	private String nama;
	
	private Integer jumlah;
	
	private Long harga;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}

	public Long getHarga() {
		return harga;
	}

	public void setHarga(Long harga) {
		this.harga = harga;
	}

	
}
