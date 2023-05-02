package com.example.fr.omg.elkino.tickets;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;

	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket findById(Integer integer) {
		return ticketRepository.findById(integer)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket non trouvé"));
	}

	public void deleteById(Integer integer) {
		ticketRepository.deleteById(integer);
	}

	public List<Ticket> findBySeanceId(Integer id) {
		return ticketRepository.findBySeanceId(id);
	}
}
