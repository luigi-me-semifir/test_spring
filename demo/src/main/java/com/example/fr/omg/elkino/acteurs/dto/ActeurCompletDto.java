package com.example.fr.omg.elkino.acteurs.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.fr.omg.elkino.films.dto.FilmReduitDto;

import lombok.Data;

@Data
public class ActeurCompletDto {
	private Integer id;
	private String nom;
	private String prenom;
	private List<FilmReduitDto> films = new ArrayList<>();

}
