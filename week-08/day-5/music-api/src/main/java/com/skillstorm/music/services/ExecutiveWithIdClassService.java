package com.skillstorm.music.services;

import org.springframework.stereotype.Service;

import com.skillstorm.music.idclasses.ExecutiveIdForIdClass;
import com.skillstorm.music.models.ExecutiveWithIdClass;
import com.skillstorm.music.repositories.ExecutiveWithIdClassRepository;

@Service
public class ExecutiveWithIdClassService {
	
	private ExecutiveWithIdClassRepository repo;
	
	public ExecutiveWithIdClassService(ExecutiveWithIdClassRepository repo) {
		this.repo = repo;
	}
	
	public Iterable<ExecutiveWithIdClass> findAll() {
		return this.repo.findAll();
	}
	
	public ExecutiveWithIdClass findById(int experience, String firstName) {
		return this.repo.findById(new ExecutiveIdForIdClass(experience, firstName)).get();
	}

}
