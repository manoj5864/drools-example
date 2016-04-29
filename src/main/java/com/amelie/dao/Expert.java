package com.amelie.dao;

import javax.persistence.*;

@SuppressWarnings("restriction")
@Entity
@Table
public class Expert {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name, experience;
	int expertise;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public int getExpertise() {
		return expertise;
	}
	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}
}
