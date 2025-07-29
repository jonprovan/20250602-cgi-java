package com.skillstorm.music.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.LabelDTO;
import com.skillstorm.music.models.Label;
import com.skillstorm.music.repositories.LabelRepository;

// this specifies that this class is a Service, which is typically used for all endpoint logic other than just pointing endpoints to their destinations
// like @Repository, this also designates this class as an injectable Component/Bean
@Service
public class LabelService {
	
	// this is dependency injection happening in real-time!
	// this automatically searches for a Bean of type LabelRepository and populates this variable with it
	// there's a best-practices way to do this coming next week
	
	// this is field injection -- however, we could construct a LabelService using the default constructor
	// and the Autowired part wouldn't happen! So the repo object would be null
	// also, we can change the value after the fact to null or something else
//	@Autowired
	private final LabelRepository repo;
	
	// this is setter injection
	// this automatically runs when the Bean is created
	// it also allows us to get around the null problem by setting repo to the right value, even if we instantiate our own
	// this still allows multiple object construction, which is not good! 
//	@Autowired
//	public void setRepo(LabelRepository repo) {
//		this.repo = repo;
//	}
	
	// this is constructor injection
	// it automatically populates the repo variable when the Bean is instantiated
	// we can now make the repo variable final
	// and we're now only ever going to have one of this class
	// @Autowired is optional here, since it's now the only constructor
	@Autowired
	public LabelService(LabelRepository repo) {
		this.repo = repo;
	}
	
	// find all labels
	// switching to a ResponseEntity so we can control the status code, headers, what's in the body, etc.
	// this uses a builder pattern where we can stack actions on each other to construct the full ResponseEntity
	public ResponseEntity<Iterable<Label>> findAll() {
		Iterable<Label> labels = this.repo.findAll();
		
		if (!labels.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
		
		return ResponseEntity.ok(labels);
	}
	
	// find a label by id
	public ResponseEntity<Label> findById(int id) {
		// findById returns an optional -- the record may or may not be present
		Optional<Label> label = this.repo.findById(id);
		
		if (label.isPresent())
			return ResponseEntity.ok(label.get());
		
		return ResponseEntity.notFound().build();
	}
	
	// create a new label
	// taking in our DTO with the label name
	public ResponseEntity<Label> createOne(LabelDTO dto) {
		
		// save is the method for BOTH create AND update
		// it requires a full Label object
		// if the ID does not match one in the DB, it will create a new record
		// if the ID DOES match, it will OVERWRITE that record
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(this.repo.save(new Label(0, dto.labelName(), null)));
	}
	
	// update one
	// we have to check if the id exists in the database before saving
	// because of the logic above -- a PUT method should NOT create a new record!
	public ResponseEntity<Label> updateOne(int id, LabelDTO dto) {
		if (this.repo.existsById(id))
			return ResponseEntity.ok(this.repo.save(new Label(id, dto.labelName(), null)));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .build();
	}
	
	// delete by id
	public ResponseEntity<Void> deleteById(int id) {
		this.repo.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	

}
