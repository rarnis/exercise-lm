package it.lm.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import it.lm.model.Category;
import it.lm.repository.CategoryRepository;

@Configuration
public class DataConfiguration {
	
	@Autowired
	private CategoryRepository repo;
	
	@PostConstruct
	public void setUp() {
		Category good = new Category();
		Category food = new Category();
		Category book = new Category();
		Category medical = new Category();
		
		good.setId(0);
		good.setDescription("Uncategorized goods");
		good.setImportTaxRate(0.05);
		good.setTaxRate(0.1);
		
		food.setId(1);
		food.setDescription("Food");
		food.setImportTaxRate(0.05);
		food.setTaxRate(0d);
		
		book.setId(2);
		book.setDescription("Books");
		book.setImportTaxRate(0.05);
		book.setTaxRate(0d);
		
		medical.setId(3);
		medical.setDescription("Medical Products");
		medical.setImportTaxRate(0.05);
		medical.setTaxRate(0d);
		
		List<Category> categories = new ArrayList<>();
		
		categories.add(good);
		categories.add(food);
		categories.add(book);
		categories.add(medical);
		
		repo.save(categories);
		
	}
	
	

}
