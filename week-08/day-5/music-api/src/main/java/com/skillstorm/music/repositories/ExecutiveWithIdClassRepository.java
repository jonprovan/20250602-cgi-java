package com.skillstorm.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.music.idclasses.ExecutiveIdForIdClass;
import com.skillstorm.music.models.ExecutiveWithIdClass;

// note the types here
// the class to be interacted with is as expected
// but the repository requires a single type for the ID, so we use the separate id class we created 
@Repository
public interface ExecutiveWithIdClassRepository extends CrudRepository<ExecutiveWithIdClass, ExecutiveIdForIdClass> {

}
