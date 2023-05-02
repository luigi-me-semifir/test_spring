package com.example.fr.omg.elkino.seances;

import java.time.LocalDate;

import com.example.fr.omg.elkino.films.Film;
import com.example.fr.omg.elkino.salle.Salle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "seance")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Seance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private Integer placesDispo;
	@Column(nullable = false)
	private float prix;

	@ManyToOne // Spécifie le type de relation - Un film peut avoir plusieurs séances (Many
				// films to One séance)
	@JoinColumn(name = "film_id") // Spécifie le nom de la colonne de liaison (FK)
	private Film film;

	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;

}
