package com.skillstorm.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.music.models.LabelHistory;

@Repository
public interface LabelHistoryRepository extends CrudRepository<LabelHistory, Integer> {

}