package com.example.cuisine.ingredients;

import java.util.List;

public class IngredientsService {
	private IngredientsRepository ingredientsRepository;

	public IngredientsService(IngredientsRepository ingredientsRepository) {
		this.ingredientsRepository = ingredientsRepository;
	}

	/**
	 * Save an ingrediant
	 *
	 * @param ingrediant ingrediant to save
	 * @return ingrediant saved
	 */
	public Ingredient save(Ingredient ingrediant) {
		return ingredientsRepository.save(ingrediant);
	}

	/**
	 * Recherche un ingrédient par id
	 *
	 * @param id
	 * @return ingrediant
	 */
	public Ingredient findById(Integer id) {
		return ingredientsRepository.findById(id).orElse(null);
	}

	/**
	 * Recherche tous les ingrédients
	 *
	 * @return List<Ingrediant>
	 */
	public List<Ingredient> findAll() {
		return ingredientsRepository.findAll();
	}

	/**
	 * Supprime un ingrédient par id
	 *
	 * @param id
	 */
	public void deleteById(Integer id) {
		ingredientsRepository.deleteById(id);
	}

	public void update(Ingredient ingrediant) {
		deleteById(ingrediant.getId());
		ingredientsRepository.save(ingrediant);
	}
}
