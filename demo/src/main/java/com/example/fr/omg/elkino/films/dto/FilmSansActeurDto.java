package com.example.fr.omg.elkino.films.dto;

import java.util.List;

import com.example.fr.omg.elkino.realisateurs.Realisateur;

import lombok.Data;

@Data
public class FilmSansActeurDto {
	private Integer id;
	private String titre;
	private Integer duree;

	private List<Realisateur> realisateurs;

}
