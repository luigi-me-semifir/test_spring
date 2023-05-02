package com.example.fr.omg.elkino.realisateurs.dto;

import java.util.List;

import com.example.fr.omg.elkino.films.dto.FilmReduitDto;

import lombok.Data;

@Data
public class RealisateurCompletDto {
	private Integer id;
	private String nom;
	private String prenom;
	private List<FilmReduitDto> films;
}
