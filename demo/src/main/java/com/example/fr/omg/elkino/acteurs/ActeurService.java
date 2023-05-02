package com.example.fr.omg.elkino.acteurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.fr.omg.elkino.acteurs.dto.ActeurCompletDto;
import com.example.fr.omg.elkino.acteurs.dto.ActeurSansFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ActeurService {

	private final ActeurRepository acteurRepository;
	private final ObjectMapper objectMapper;

	public ActeurService(ActeurRepository acteurRepository, ObjectMapper objectMapper) {
		this.acteurRepository = acteurRepository;
		this.objectMapper = objectMapper;
	}

	public List<ActeurSansFilmDto> findAll() {
		List<Acteur> acteurs = acteurRepository.findAll();
		return acteurs.stream().map(acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)).toList();
	}

	public ActeurCompletDto save(Acteur acteur) {
		Acteur entite = acteurRepository.save(acteur);
		return objectMapper.convertValue(entite, ActeurCompletDto.class);
	}

	public ActeurCompletDto findById(Integer id) {
		Acteur acteur = acteurRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Acteur non trouvé"));
		return objectMapper.convertValue(acteur, ActeurCompletDto.class);
	}

	public void deleteById(Integer id) {
		acteurRepository.deleteById(id);
	}

	public Acteur findOrInsertActeur(Acteur acteur) {
		return acteurRepository.findById(acteur.getId()).orElseGet(() -> acteurRepository.save(acteur));
	}
}
