package com.amelie.dao;

import javax.persistence.*;

@SuppressWarnings("restriction")
@Entity
@Table
public class Task {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(targetEntity=Project.class)
	@JoinColumn(name="project_id", referencedColumnName="id")
    private Project project;
	
	private String status, name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    
    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", project="
                + project.getName() + "]";
    }
}
