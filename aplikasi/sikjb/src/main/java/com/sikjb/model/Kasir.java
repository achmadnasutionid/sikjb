package com.sikjb.model;

import javax.persistence.*;

@Entity
@Table(name = "kasir")
public class Kasir {
	
	@Id
	@GeneratedValue(generator = "kasir_generator")
	@SequenceGenerator(
			name = "kasir_generator",
			sequenceName = "kasir_generator",
			initialValue = 1
	)
	private Long Id;
	
	private String nama;
	
	private String alamat;

	private String telepon;

	private Integer nik;
	
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

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Integer getTelepon() {
		return telepon;
	}

	public void setTelepon(Integer telepon) {
		this.telepon = telepon;
	}

	public Integer getNik() {
		return nik;
	}

	public void setNik(Integer nik) {
		this.nik = nik;
	}

}
