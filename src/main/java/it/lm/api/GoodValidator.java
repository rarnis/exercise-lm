package it.lm.api;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.lm.model.Category;
import it.lm.model.Good;

public class GoodValidator implements Validator {
	
	private Collection<Category> list;
	
	public GoodValidator(Collection<Category> categories) {
		this.list = categories;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(Good.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		if(list!=null && !list.isEmpty()) {
		
			List<Good> goods = (List<Good>)arg0;
			List<Integer> categorieIds = list.stream().map(c -> c.getId()).collect(Collectors.toList());
			goods.stream().filter(g -> g.getCategoryId()==null || !categorieIds.contains(g.getCategoryId())).forEach(g -> arg1.reject(g.getDescription()+" has Invalid category"));
		}		

	}

}
