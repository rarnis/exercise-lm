package it.lm.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lm.model.Category;
import it.lm.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository repo;

	@Override
	public Collection<Category> findAll() {
		
		return (Collection<Category>) repo.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return repo.findOne(id);
	}

}
