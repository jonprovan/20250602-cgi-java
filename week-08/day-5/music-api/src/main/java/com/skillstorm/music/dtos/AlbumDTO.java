package com.skillstorm.music.dtos;

import java.util.List;

import com.skillstorm.music.models.Artist;

public record AlbumDTO(String albumName, int releaseYear, List<Artist> artists) {}