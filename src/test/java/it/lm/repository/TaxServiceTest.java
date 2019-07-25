package it.lm.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.lm.model.Good;
import it.lm.model.Order;
import it.lm.service.TaxService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxServiceTest {

	@Autowired
	private TaxService ts;

	@Test
	public void whenGoodIsNotTaxedAndNotImported() {


		List<Good> goods = new ArrayList<Good>();

		Good g = null;

		g = new Good();
		g.setCategoryId(2);
		g.setQuantity(1);
		g.setDescription("book");
		g.setImported(false);
		g.setPrice(12.49);

		goods.add(g);

		g = new Good();
		g.setCategoryId(0);
		g.setQuantity(1);
		g.setDescription("music CD");
		g.setImported(false);
		g.setPrice(14.99);
		goods.add(g);

		g = new Good();
		g.setCategoryId(1);
		g.setQuantity(1);
		g.setDescription("chocolate bar");
		g.setImported(false);
		g.setPrice(0.85);

		goods.add(g);

		Order o = ts.buildOrder(goods);

		assertThat("Taxes", o.getTaxes(), is(1.5));
		assertThat("Total", o.getTotal(), is(29.83));
	}

	@Test
	public void whenGoodIsGeneralAndImported() {

		List<Good> goods = new ArrayList<Good>();

		Good g = null;

		g = new Good();
		g.setCategoryId(1);
		g.setQuantity(1);
		g.setDescription("imported box of chocolates");
		g.setImported(true);
		g.setPrice(10.00);
		goods.add(g);

		g = new Good();
		g.setCategoryId(0);
		g.setQuantity(1);
		g.setDescription("imported bottle of perfume");
		g.setImported(true);
		g.setPrice(47.50);
		goods.add(g);
		
		Order o = ts.buildOrder(goods);
		
		assertThat("Taxes", o.getTaxes(), is(7.65));
		assertThat("Total", o.getTotal(), is(65.15));
	}
}
