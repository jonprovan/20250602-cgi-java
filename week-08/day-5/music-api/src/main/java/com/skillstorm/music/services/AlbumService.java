package com.skillstorm.music.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.AlbumDTO;
import com.skillstorm.music.models.Album;
import com.skillstorm.music.repositories.AlbumRepository;
import com.skillstorm.music.repositories.ArtistRepository;
import com.skillstorm.music.models.Artist;
import java.util.LinkedList;
import java.util.List;

@Service
public class AlbumService {
	
	private final AlbumRepository repo;
	private final ArtistRepository artistRepo;

	public AlbumService(AlbumRepository repo, ArtistRepository artistRepo) {
		this.repo = repo;
		this.artistRepo = artistRepo;
	}
	
	// find all
	public ResponseEntity<Iterable<Album>> findAll() {
		Iterable<Album> albums = this.repo.findAll();
		
		if (!albums.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .build();
		
		return ResponseEntity.ok(albums);
	}
	
	// find by id
	public ResponseEntity<Album> findById(int id) {
		Optional<Album> album = this.repo.findById(id);
		
		if (album.isPresent())
			return ResponseEntity.ok(album.get());
		
		return ResponseEntity.notFound().build();
	}
	
	// create one
	public ResponseEntity<Album> createOne(AlbumDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(this.repo.save(new Album(0, dto.albumName(), dto.releaseYear(), dto.artists())));
	}
	
	// update one
	public ResponseEntity<Album> updateOne(int id, AlbumDTO dto) {
		if (this.repo.existsById(id)) {
			
			// get the album from the DB, then set the name and year from the DTO
			Album album = this.repo.findById(id).get();
			album.setAlbumName(dto.albumName());
			album.setReleaseYear(dto.releaseYear());
			
			// Get all artist IDs from the DTO, add them to a list, then assemble a list of artist records from the DB
			List<Integer> artistIds = new LinkedList<>();
			for (Artist artist : dto.artists()) {
				artistIds.add(artist.getId());
			}
			List<Artist> artists = (List<Artist>)this.artistRepo.findAllById(artistIds);
			
			// if an artist in the album from the DB is not in the DTO list, remove the album from that artist's albums list
			List<Artist> previousArtists = album.getArtists();
			for (Artist previousArtist : previousArtists) {
				if (!artists.contains(previousArtist)) {
					previousArtist.getAlbums().remove(album);
				}
			}
			
			// if any artist to be added does not have this album on their list, add it
			for (Artist artist : artists) {
				if (!artist.getAlbums().contains(album)) {
					artist.getAlbums().add(album);
				}
			}
			
			// finally, apply the updated artists list to the album
			album.setArtists(artists);
			
			return ResponseEntity.ok(this.repo.save(album));
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