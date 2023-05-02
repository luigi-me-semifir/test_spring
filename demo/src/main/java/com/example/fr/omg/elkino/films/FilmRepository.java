package com.example.fr.omg.elkino.films;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository de gestion des films généré par JPA Généricité : <Entité, Type de
 * l'ID>
 */
public interface FilmRepository extends JpaRepository<Film, Integer> {
	<List> Film findByTitre(String titre);

	<List> Film findByTitreContaining(String titre);

	<List> Film findByDateSortie(LocalDate dateSortie);

	<List> Film findByDateSortieBetween(LocalDate dateDebut, LocalDate dateFin);
}
