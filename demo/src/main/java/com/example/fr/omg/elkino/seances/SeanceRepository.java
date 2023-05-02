package com.example.fr.omg.elkino.seances;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Integer> {
	public List<Seance> findByDate(LocalDate date);
}
