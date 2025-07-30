package com.skillstorm.music.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.ArtistDTO;
import com.skillstorm.music.models.Artist;
import com.skillstorm.music.repositories.ArtistRepository;
import com.skillstorm.music.repositories.AlbumRepository;
import com.skillstorm.music.models.Album;
import java.util.LinkedList;
import java.util.List;

@Service
public class ArtistService {
	
	private final ArtistRepository repo;
	private final AlbumRepository albumRepo;

	public ArtistService(ArtistRepository repo, AlbumRepository albumRepo) {
		this.repo = repo;
		this.albumRepo = albumRepo;
	}
	
	// find all
	public ResponseEntity<Iterable<Artist>> findAll() {
		Iterable<Artist> artists = this.repo.findAll();
		
		if (!artists.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .build();
		
		return ResponseEntity.ok(artists);
	}
	
	// find by id
	public ResponseEntity<Artist> findById(int id) {
		Optional<Artist> artist = this.repo.findById(id);
		
		if (artist.isPresent())
			return ResponseEntity.ok(artist.get());
		
		return ResponseEntity.notFound().build();
	}
	
	// create one
	public ResponseEntity<Artist> createOne(ArtistDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(this.repo.save(new Artist(0, dto.artistName(), dto.label(), dto.albums())));
	}
	
	// update one
	public ResponseEntity<Artist> updateOne(int id, ArtistDTO dto) {
		if (this.repo.existsById(id)) {
			
			// get the artist from the DB, then set the name and label from the DTO
			Artist artist = this.repo.findById(id).get();
			artist.setArtistName(dto.artistName());
			artist.setLabel(dto.label());
			
			// Get all album IDs from the DTO, add them to a list, then assemble a list of album records from the DB
			List<Integer> albumIds = new LinkedList<>();
			for (Album album : dto.albums()) {
				albumIds.add(album.getId());
			}
			List<Album> albums = (List<Album>) this.albumRepo.findAllById(albumIds);
			
			// if an album in the artist from the DB is not in the DTO list, remove the artist from that album's artists list
			List<Album> previousAlbums = artist.getAlbums();
			for (Album previousAlbum : previousAlbums) {
				if (!albums.contains(previousAlbum)) {
					previousAlbum.getArtists().remove(artist);
				}
			}
			
			// if any album to be added does not have this artist on their list, add it
			for (Album album : albums) {
				if (!album.getArtists().contains(artist)) {
					album.getArtists().add(artist);
				}
			}
			
			// finally, apply the updated albums list to the artist
			artist.setAlbums(albums);
			
			return ResponseEntity.ok(this.repo.save(artist));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .build();
	}
	
	// delete by id
	public ResponseEntity<Void> deleteById(int id) {
		this.repo.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
