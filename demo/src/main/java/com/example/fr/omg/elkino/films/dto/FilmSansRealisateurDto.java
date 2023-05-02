package com.example.fr.omg.elkino.films.dto;

import java.util.List;

import com.example.fr.omg.elkino.acteurs.dto.ActeurSansFilmDto;

import lombok.Data;

@Data
public class FilmSansRealisateurDto {
	private Integer id;
	private String titre;
	private Integer duree;

	private List<ActeurSansFilmDto> acteurs;

}
