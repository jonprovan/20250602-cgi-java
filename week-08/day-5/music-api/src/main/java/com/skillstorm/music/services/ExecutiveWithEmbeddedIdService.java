package com.skillstorm.music.services;

import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.ExecutiveWithEmbeddedIdDTO;
import com.skillstorm.music.idclasses.ExecutiveIdForEmbeddedId;
import com.skillstorm.music.models.ExecutiveWithEmbeddedId;
import com.skillstorm.music.repositories.ExecutiveWithEmbeddedIdRepository;

@Service
public class ExecutiveWithEmbeddedIdService {
	
	private ExecutiveWithEmbeddedIdRepository repo;
	
	public ExecutiveWithEmbeddedIdService(ExecutiveWithEmbeddedIdRepository repo) {
		this.repo = repo;
	}
	
	public Iterable<ExecutiveWithEmbeddedId> findAll() {
		return this.repo.findAll();
	}
	
	public ExecutiveWithEmbeddedId findById(ExecutiveWithEmbeddedIdDTO dto) {
		return this.repo.findById(new ExecutiveIdForEmbeddedId(dto.experience(), dto.firstName())).get();
	}

}