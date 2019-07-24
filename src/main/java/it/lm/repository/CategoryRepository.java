package it.lm.repository;

import org.springframework.data.repository.CrudRepository;

import it.lm.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
