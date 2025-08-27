package com.skillstorm.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.music.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
	
	Iterable<Album> findByReleaseYearBetween(int from, int to);

}
