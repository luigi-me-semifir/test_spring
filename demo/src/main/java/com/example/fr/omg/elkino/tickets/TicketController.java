package com.example.fr.omg.elkino.tickets;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fr.omg.elkino.tickets.dto.TicketCompletDto;
import com.example.fr.omg.elkino.tickets.dto.TicketReduitDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {

	private final TicketService ticketService;
	private final ObjectMapper objectMapper;

	public TicketController(TicketService ticketService, ObjectMapper objectMapper) {
		this.ticketService = ticketService;
		this.objectMapper = objectMapper;
	}

	@GetMapping

	public List<TicketCompletDto> findAll() {
		List<Ticket> tickets = ticketService.findAll();
		return tickets.stream().map(ticket -> objectMapper.convertValue(ticket, TicketCompletDto.class)).toList();
	}

	@PostMapping
	public TicketReduitDto save(@RequestBody Ticket ticket) {
		Ticket nouveauTicket = ticketService.save(ticket);
		return objectMapper.convertValue(nouveauTicket, TicketReduitDto.class);
	}

	@GetMapping("/{id}")
	public TicketCompletDto findById(@PathVariable Integer id) {
		Ticket ticket = ticketService.findById(id);
		return objectMapper.convertValue(ticket, TicketCompletDto.class);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		ticketService.deleteById(id);
	}

}
