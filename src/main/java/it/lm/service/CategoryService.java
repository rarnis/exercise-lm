package it.lm.service;

import java.util.Collection;

import it.lm.model.Category;

public interface CategoryService {
	
	public Collection<Category> findAll();
	public Category findById(Integer id);

}
