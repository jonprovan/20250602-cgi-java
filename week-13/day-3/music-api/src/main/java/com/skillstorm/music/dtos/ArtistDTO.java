package com.skillstorm.music.dtos;

import java.util.List;

import com.skillstorm.music.models.Album;
import com.skillstorm.music.models.Label;

public record ArtistDTO(String artistName, Label label, List<Album> albums) {}