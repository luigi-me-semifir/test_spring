package com.example.fr.omg.elkino.acteurs;

import java.util.ArrayList;
import java.util.List;

import com.example.fr.omg.elkino.films.Film;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "acteur")
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	private String nom;

	private String prenom;

	// Spécifie le type de relation - Un acteur peut jouer dans plusieurs films
	// (Many acteurs to Many films)
	@ManyToMany(mappedBy = "acteurs", cascade = CascadeType.PERSIST)
	// Spécifie le nom de la table de liaison

	private List<Film> films = new ArrayList<>();
}
