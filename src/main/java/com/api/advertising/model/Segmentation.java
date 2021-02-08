package com.api.advertising.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Segmentations")
public class Segmentation implements Serializable {

	private static final long serialVersionUID = -2393073399693591270L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private Integer age;
	private String gender;
	@OneToOne(mappedBy = "segmentation", fetch = FetchType.LAZY)
	private Ad ad;

	public Segmentation() {
	}

	public Segmentation(Long id, String country, Integer age, String gender) {
		this.id = id;
		this.country = country;
		this.age = age;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
