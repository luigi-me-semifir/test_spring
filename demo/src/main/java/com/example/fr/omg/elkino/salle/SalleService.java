package com.example.fr.omg.elkino.salle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SalleService {
	private final SalleRepository salleRepository;

	public SalleService(SalleRepository salleRepository) {
		this.salleRepository = salleRepository;
	}

	public List<Salle> findAll() {
		return salleRepository.findAll();
	}

	public Salle save(Salle salle) {
		return salleRepository.save(salle);
	}

	public Salle findById(Integer id) {
		return salleRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Salle non trouvée"));
	}

	public void deleteById(Integer id) {
		salleRepository.deleteById(id);
	}
}
