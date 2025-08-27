package com.skillstorm.music.repositories;

import org.springframework.data.repository.CrudRepository;

import com.skillstorm.music.idclasses.ExecutiveIdForEmbeddedId;
import com.skillstorm.music.models.ExecutiveWithEmbeddedId;

public interface ExecutiveWithEmbeddedIdRepository extends CrudRepository<ExecutiveWithEmbeddedId, ExecutiveIdForEmbeddedId> {

}
