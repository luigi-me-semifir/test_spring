package com.example.gestiondatespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * Payload entity class for the database.
 * This class is annotated with @Entity to be recognized by Spring Data JPA.
 * This class is annotated with @Data to generate getters and setters.
 * This class is annotated with @Id to specify the primary key.
 * This class is annotated with @GeneratedValue to specify the primary key generation strategy.
 */
@Data
@Entity
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private LocalDateTime dateTime;
}
