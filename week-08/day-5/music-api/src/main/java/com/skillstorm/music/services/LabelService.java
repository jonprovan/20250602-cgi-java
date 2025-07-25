package com.skillstorm.music.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.music.models.Label;
import com.skillstorm.music.repositories.LabelRepository;

// this specifies that this class is a Service, which is typically used for all endpoint logic other than just pointing endpoints to their destinations
// like @Repository, this also designates this class as an injectable Component/Bean
@Service
public class LabelService {
	
	// this automatically searches for a Bean of type LabelRepository and populates this variable with it
	// there's a best-practices way to do this coming next week
	@Autowired
	private LabelRepository repo;
	
	// find all labels
	public Iterable<Label> findAll() {
		return this.repo.findAll();
	}

}
