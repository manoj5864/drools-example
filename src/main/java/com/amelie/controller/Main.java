package com.amelie.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.amelie.dao.Expert;
import com.amelie.dao.Project;
import com.amelie.dao.Task;

@SuppressWarnings("restriction")
public class Main {

	public static void main(String[] args) {
		fireDrools();
	}

	private static void fireDrools() {
		KieSession kSession = initializeKSession();
        kSession.fireAllRules();
        kSession.dispose();
	}

	private static KieSession initializeKSession() {
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	EntityManager entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
		
    	@SuppressWarnings("unchecked")
		List<Project> projects = (List<Project>) entityManager.createNativeQuery("select * from project", Project.class).getResultList();
        
        for(Project p :projects){
        	kSession.insert(p);
        }
        
        @SuppressWarnings("unchecked")
		List<Task> tasks = (List<Task>) entityManager.createNativeQuery("select * from task", Task.class).getResultList();
        for(Task task :tasks){
        	kSession.insert(task);
        }
        
        @SuppressWarnings("unchecked")
		List<Expert> experts = (List<Expert>) entityManager.createNativeQuery("select * from expert", Expert.class).getResultList();
        for(Expert expert :experts){
        	kSession.insert(expert);
        }
        
        return kSession;
	}
}
