package com.amelie.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("restriction")
@Entity
@Table
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	
	private String phase; 
	private String status; 
	private String name;
	
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL, targetEntity=Task.class)
    private Set<Task> tasks;
	
	public Project() {
		
	}
	
	public Project(String name, String phase, String status) {
		this.name = name;
		this.phase = phase;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Task> getEmployees() {
        return tasks;
    }
    public void setEmployees(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
