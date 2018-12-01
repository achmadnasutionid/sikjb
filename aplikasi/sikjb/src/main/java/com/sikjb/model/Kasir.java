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
	
	private String name;
	
	private String address;

	private String telephone;

	private Integer nik;
	
	public Long getKasirById() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getKasirByName() {
		return name;
	}

	public void setNama(String name) {
		this.name = name;
	}

	public String getKasirByAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKasirByTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer geKasirBytNik() {
		return nik;
	}

	public void setNik(Integer nik) {
		this.nik = nik;
	}

}
