package com.skillstorm.music.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.music.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
	
	// this method uses a prefab JPA Query syntax that allows us to access certain functions
	// it will find all Artists in the DB whose artist_name property starts with whatever we feed into it
	// check here for info -- https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	Iterable<Artist> findByArtistNameStartingWith(String startsWith);
	
	// a custom query for adding an entry to the artist_albums_album join table
	// this is a MUCH simpler way of dealing with the join table for updates rather than the update method logic present in the service
	// for non-select queries that include things like INSERT, UPDATE, DELETE, we need these two extra annotations
	// Transactional states that ALL of this will happen, or NONE of it will
	// Modifying states that we're changing something about the database, whether it's data or structure
	// in the Query annotation, the value is the query text in SQL syntax, nativeQuery allows us to write native SQL syntax
	// you can use wildcards to plant the variables you take in into your query
	// ?1 = the first variable in the parameters list, ?2 = the second one, and so on
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO artist_albums_album(artist_id, album_id) VALUES(?1, ?2)", nativeQuery = true)
	Object connectArtistToAlbum(int artistId, int albumId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM artist_albums_album WHERE artist_id = ?1 AND album_id = ?2", nativeQuery = true)
	Object disconnectArtistFromAlbum(int artistId, int albumId);

}