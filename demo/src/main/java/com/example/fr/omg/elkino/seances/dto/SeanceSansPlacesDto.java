package com.example.fr.omg.elkino.seances.dto;

import java.time.LocalDate;

import com.example.fr.omg.elkino.films.dto.FilmReduitDto;
import com.example.fr.omg.elkino.salle.dto.SalleSansPlacesDto;

import lombok.Data;

@Data
public class SeanceSansPlacesDto {
	private Integer id;
	private LocalDate date;
	private float prix;

	private FilmReduitDto film;

	private SalleSansPlacesDto salle;
}
