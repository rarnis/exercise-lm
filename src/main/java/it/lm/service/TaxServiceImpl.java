package it.lm.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lm.model.Category;
import it.lm.model.Good;
import it.lm.model.Order;

@Service
public class TaxServiceImpl implements TaxService {
	
	@Autowired
	private CategoryService cs;

	@Override
	public Order buildOrder(Collection<Good> goods) {
		
		Order o = new Order();
		double taxes = 0d;
		double total = 0d;
		double tax = 0;
		
		Category c = null;
		Good ordered = null;
		
		List<Good> orders = new ArrayList<Good>();
		
		for(Good g : goods) {
			c = cs.findById(g.getCategoryId());
			tax = g.getPrice()*c.getTaxRate();
			if(g.isImported()) {
				tax+=g.getPrice()*c.getImportTaxRate();
			}
			
			tax = Math.round(tax * 20.0) / 20.0;
			
			ordered = new Good();
			ordered.setCategoryId(g.getCategoryId());
			ordered.setDescription(g.getDescription());
			ordered.setImported(g.isImported());
			ordered.setQuantity(g.getQuantity()!=null?g.getQuantity():0);
			ordered.setPrice(g.getPrice()+tax);
			
			orders.add(ordered);
			
			taxes+=tax;
			total+=ordered.getQuantity()*ordered.getPrice();
		}
		
		o.setGoods(orders);
		o.setTaxes(BigDecimal.valueOf(taxes).setScale(2, RoundingMode.DOWN).doubleValue());
		o.setTotal(BigDecimal.valueOf(total).setScale(2, RoundingMode.DOWN).doubleValue());
		
		return o;
	}

}
