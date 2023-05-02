package com.example.cuisine.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{
	
	<List> Categories findByNom(String nom);
}
