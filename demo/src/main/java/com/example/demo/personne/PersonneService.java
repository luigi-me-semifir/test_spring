package com.example.demo.personne;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class PersonneService {
	
	private final PersonneRepository personneRepository;
	
	public PersonneService(PersonneRepository personneRepository) {
		this.personneRepository = personneRepository;
	}
	
	public List<Personne> findAll(){
		return personneRepository.findAll();
	}
	
	public Personne save(Personne personne) {
		personneRepository.save(personne);
		return personne;
	}
	
	public Personne findById(int id){
		return personneRepository.findById(id).orElse(null);
	}
	
	public void deleteById(int id) {
		personneRepository.deleteById(id);
	}
	
	public void update(int id, Personne personne) {
		personneRepository.save(personne);
	}

}
