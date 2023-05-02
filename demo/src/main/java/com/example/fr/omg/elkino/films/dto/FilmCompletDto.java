package com.example.fr.omg.elkino.films.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.fr.omg.elkino.acteurs.dto.ActeurSansFilmDto;
import com.example.fr.omg.elkino.realisateurs.dto.RealisateurSansFilmDto;

import lombok.Data;

@Data
public class FilmCompletDto {
	private Integer id;
	private String titre;
	private LocalDate dateSortie;
	private String synopsis;
	private Integer duree;
	private List<ActeurSansFilmDto> acteurs = new ArrayList<>();

	private List<RealisateurSansFilmDto> realisateurs = new ArrayList<>();
}
