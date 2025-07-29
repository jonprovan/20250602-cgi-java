package com.skillstorm.music.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.LabelHistoryDTO;
import com.skillstorm.music.models.LabelHistory;
import com.skillstorm.music.repositories.LabelHistoryRepository;

@Service
public class LabelHistoryService {
	
	private final LabelHistoryRepository repo;
	
	public LabelHistoryService(LabelHistoryRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<LabelHistory>> findAll() {
		Iterable<LabelHistory> labelHistories = this.repo.findAll();
		
		if (!labelHistories.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .build();
		
		return ResponseEntity.ok(labelHistories);
	}
	
	// find by id
	public ResponseEntity<LabelHistory> findById(int id) {
		Optional<LabelHistory> labelHistory = this.repo.findById(id);
		
		if (labelHistory.isPresent())
			return ResponseEntity.ok(labelHistory.get());
		
		return ResponseEntity.notFound().build();
	}
	
	// create one
	public ResponseEntity<LabelHistory> createOne(LabelHistoryDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(this.repo.save(new LabelHistory(0, dto.history(), dto.label())));
	}
	
	// update one
	public ResponseEntity<LabelHistory> updateOne(int id, LabelHistoryDTO dto) {
		if (this.repo.existsById(id))
			return ResponseEntity.ok(this.repo.save(new LabelHistory(id, dto.history(), dto.label())));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .build();
	}
	
	// delete by id
	public ResponseEntity<Void> deleteById(int id) {
		this.repo.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
