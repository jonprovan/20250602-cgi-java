package com.skillstorm.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.music.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

}
