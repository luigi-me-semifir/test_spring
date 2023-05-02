package com.example.fr.omg.elkino.acteurs;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fr.omg.elkino.acteurs.dto.ActeurCompletDto;
import com.example.fr.omg.elkino.acteurs.dto.ActeurSansFilmDto;

@RestController
@RequestMapping("/acteurs")
@CrossOrigin
public class ActeurController {
	private final ActeurService acteurService;

	public ActeurController(ActeurService acteurService) {
		this.acteurService = acteurService;
	}

	@GetMapping
	public List<ActeurSansFilmDto> findAll() {
		return acteurService.findAll();
	}

	@PostMapping
	public ActeurCompletDto save(@RequestBody Acteur acteur) {
		return acteurService.save(acteur);
	}

	@GetMapping("{id}")
	public ActeurCompletDto findById(@PathVariable Integer id) {
		return acteurService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		acteurService.deleteById(id);
	}
}
