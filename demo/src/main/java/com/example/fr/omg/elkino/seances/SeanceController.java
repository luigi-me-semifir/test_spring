package com.example.fr.omg.elkino.seances;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fr.omg.elkino.seances.dto.SeanceCompletDto;
import com.example.fr.omg.elkino.tickets.Ticket;
import com.example.fr.omg.elkino.tickets.TicketService;
import com.example.fr.omg.elkino.tickets.dto.TicketCompletDto;
import com.example.fr.omg.elkino.tickets.dto.TicketReduitDto;
import com.example.fr.omg.elkino.tickets.dto.TicketSansSeance;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/seances")
@CrossOrigin
public class SeanceController {

	private final SeanceService seanceService;
	private final TicketService ticketService;
	private final ObjectMapper objectMapper;

	public SeanceController(SeanceService seanceService, TicketService ticketService, ObjectMapper objectMapper) {
		this.seanceService = seanceService;
		this.ticketService = ticketService;
		this.objectMapper = objectMapper;
	}

	/**
	 * Ajoute une séance
	 * 
	 * @param seance
	 * @return Séance
	 */
	@PostMapping
	public SeanceCompletDto save(@RequestBody Seance seance) {
		Seance nouvelleSeance = seanceService.save(seance);
		return objectMapper.convertValue(nouvelleSeance, SeanceCompletDto.class);
	}

	/**
	 * Récupère toutes les séances
	 * 
	 * @return Liste de séances
	 */
	@GetMapping
	public List<SeanceCompletDto> findAll() {
		List<Seance> seances = seanceService.findAll();
		return seances.stream().map(seance -> objectMapper.convertValue(seance, SeanceCompletDto.class)).toList();
	}

	/**
	 * Récupère une séance par son id
	 * 
	 * @param id
	 * @return Séance
	 */
	@GetMapping("{id}")
	public SeanceCompletDto findById(@PathVariable Integer id) {
		Seance seance = seanceService.findById(id);
		return objectMapper.convertValue(seance, SeanceCompletDto.class);
	}

	/**
	 * Supprime une séance par son id
	 * 
	 * @param id
	 */
	@DeleteMapping("{id}")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	public void deleteById(@PathVariable Integer id) {
		seanceService.deleteById(id);
	}

	@GetMapping("date")
	public List<SeanceCompletDto> findByDate(@RequestParam String date) {
		List<Seance> seances = seanceService.findByDate(date);
		return seances.stream().map(seance -> objectMapper.convertValue(seance, SeanceCompletDto.class)).toList();
	}

	@GetMapping("{id}/tickets")
	public List<TicketCompletDto> getTickets(@PathVariable Integer id) {
		List<Ticket> tickets = seanceService.getTickets(id);
		return tickets.stream().map(ticket -> objectMapper.convertValue(ticket, TicketCompletDto.class)).toList();
	}

	@PostMapping("{id}/reserver")
	public TicketReduitDto reserver(@PathVariable Integer id, @RequestBody TicketSansSeance ticketACreer) {
		Ticket ticket = objectMapper.convertValue(ticketACreer, Ticket.class);
		ticket.setSeance(seanceService.findById(id));
		seanceService.reserver(id, ticket);
		return objectMapper.convertValue(ticket, TicketReduitDto.class);
	}

}
