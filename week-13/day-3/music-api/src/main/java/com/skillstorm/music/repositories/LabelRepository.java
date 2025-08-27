package com.skillstorm.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.music.models.Label;

// this specifies that this class is a Spring Repository, which provides ready-to-go methods for interacting with the database
// this annotation ALSO makes this interface available as a Component (a special type of Bean)
// it can therefore be injected into other classes as necessary
@Repository
// we extend CrudRepository to get that functionality, and we have to specify which entity to use and the type of its primary key
public interface LabelRepository extends CrudRepository<Label, Integer> {

}