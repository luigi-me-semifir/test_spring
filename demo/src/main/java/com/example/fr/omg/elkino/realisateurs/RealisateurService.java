package com.example.fr.omg.elkino.realisateurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.fr.omg.elkino.realisateurs.dto.RealisateurCompletDto;
import com.example.fr.omg.elkino.realisateurs.dto.RealisateurSansFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RealisateurService {
	private final RealisateurRepository realisateurRepository;
	private final ObjectMapper objectMapper;

	public RealisateurService(RealisateurRepository realisateurRepository, ObjectMapper objectMapper) {
		this.realisateurRepository = realisateurRepository;
		this.objectMapper = objectMapper;
	}

	public List<RealisateurSansFilmDto> findAll() {

		List<Realisateur> realisateurs = realisateurRepository.findAll();
		return realisateurs.stream()
				.map(realisateur -> objectMapper.convertValue(realisateur, RealisateurSansFilmDto.class)).toList();
	}

	public RealisateurCompletDto save(Realisateur entity) {
		Realisateur realisateur = realisateurRepository.save(entity);
		return objectMapper.convertValue(realisateur, RealisateurCompletDto.class);
	}

	public RealisateurCompletDto findById(Integer id) {
		Realisateur realisateur = realisateurRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return objectMapper.convertValue(realisateur, RealisateurCompletDto.class);
	}

	public void deleteById(Integer id) {
		realisateurRepository.deleteById(id);
	}
}
