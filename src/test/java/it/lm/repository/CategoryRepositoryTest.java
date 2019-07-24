package it.lm.repository;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.lm.model.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repo;

	
	
	@Test
	public void whenFindById_thenReturnCategory() {
	    // given
	    Category food = new Category();
	    food.setId(1);
	    food.setDescription("Food");
	    food.setImportTaxRate(0.05);
	    food.setTaxRate(0d);
	    
	    repo.save(food);
	 
	    // when
	    Category found = repo.findOne(1);
	 
	    // then
	    assertThat("Found food",found.getId(),is(1));
	}
}
