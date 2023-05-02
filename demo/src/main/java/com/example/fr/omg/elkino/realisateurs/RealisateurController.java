package com.example.fr.omg.elkino.realisateurs;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fr.omg.elkino.realisateurs.dto.RealisateurCompletDto;
import com.example.fr.omg.elkino.realisateurs.dto.RealisateurSansFilmDto;

@RestController
@RequestMapping("/realisateurs")
@CrossOrigin
public class RealisateurController {
	private final RealisateurService realisateurService;

	public RealisateurController(RealisateurService realisateurService) {
		this.realisateurService = realisateurService;
	}

	@GetMapping
	public List<RealisateurSansFilmDto> findAll() {
		return realisateurService.findAll();
	}

	@PostMapping
	public RealisateurCompletDto save(@RequestBody Realisateur entity) {
		return realisateurService.save(entity);
	}

	@GetMapping("{id}")
	public RealisateurCompletDto findById(@PathVariable Integer id) {
		return realisateurService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		realisateurService.deleteById(id);
	}
}
