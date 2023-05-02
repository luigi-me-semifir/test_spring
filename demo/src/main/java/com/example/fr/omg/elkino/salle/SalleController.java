package com.example.fr.omg.elkino.salle;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fr.omg.elkino.salle.dto.SalleCompletDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/salles")
public class SalleController {

	private final SalleService salleService;
	private final ObjectMapper objectMapper;

	public SalleController(SalleService salleService, ObjectMapper objectMapper) {
		this.salleService = salleService;
		this.objectMapper = objectMapper;
	}

	@GetMapping
	public List<SalleCompletDto> findAll() {
		List<Salle> salles = salleService.findAll();
		return salles.stream().map(salle -> objectMapper.convertValue(salle, SalleCompletDto.class)).toList();
	}

	@PostMapping
	public SalleCompletDto save(@RequestBody Salle salle) {
		Salle nouvelleSalle = salleService.save(salle);
		return objectMapper.convertValue(nouvelleSalle, SalleCompletDto.class);
	}

	@GetMapping("/{id}")
	public SalleCompletDto findById(@PathVariable Integer id) {
		Salle salle = salleService.findById(id);
		return objectMapper.convertValue(salle, SalleCompletDto.class);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		salleService.deleteById(id);
	}
}
