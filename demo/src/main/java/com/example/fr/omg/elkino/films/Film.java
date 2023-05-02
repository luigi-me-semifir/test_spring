package com.example.fr.omg.elkino.films;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.fr.omg.elkino.acteurs.Acteur;
import com.example.fr.omg.elkino.realisateurs.Realisateur;
// Jakarta (JEE) Persistence = JPA
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter // Ajoute les getters
@Setter // Ajoute les setters
@ToString // Ajoute la méthode toString()
@NoArgsConstructor // Ajoute le constructeur sans paramètre
@Table(name = "film")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Film {
	// @Id = Primary Key
	@Id
	// @GeneratedValue = Auto Increment
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	// @Column = Column Name
	@Column(nullable = false)
	private String titre;

	@Column(nullable = false)
	private LocalDate dateSortie;

	// Si @Column n'est pas spécifié, le nom de la colonne est le nom de l'attribut
	// Ce sera tout de même ajouté à la table
	private int duree;

	@Column(length = 500)
	private String synopsis;

	// Ne sera pas repris dans la table
	@Transient
	private String attributSansLienBdd;

	// /!\ : Many to Many bidirectionnel : boucle infinie
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "acteur_film",
			// Spécifie le nom de la colonne de liaison (FK) pour la table courante
			joinColumns = @JoinColumn(name = "film_id"),
			// Spécifie le nom de la colonne de liaison (FK) pour la table liée
			inverseJoinColumns = @JoinColumn(name = "acteur_id"))
	private List<Acteur> acteurs = new ArrayList<>();

	@ManyToMany(mappedBy = "films", cascade = CascadeType.PERSIST)
	private List<Realisateur> realisateurs = new ArrayList<>();

}
