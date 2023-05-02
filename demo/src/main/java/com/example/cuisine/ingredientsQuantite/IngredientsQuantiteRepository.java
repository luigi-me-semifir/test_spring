package com.example.cuisine.ingredientsQuantite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsQuantiteRepository extends JpaRepository<IngredientsQuantite, Integer> {}
