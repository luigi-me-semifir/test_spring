package com.example.fr.omg.elkino.tickets.dto;

import com.example.fr.omg.elkino.seances.dto.SeanceSansPlacesDto;

import lombok.Data;

@Data
public class TicketReduitDto {
	private Integer id;
	private String nomClient;
	private Integer nombrePlaces;
	private SeanceSansPlacesDto seance;
}
