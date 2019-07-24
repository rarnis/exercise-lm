package it.lm.service;

import java.util.Collection;

import it.lm.model.Good;
import it.lm.model.Order;

public interface TaxService {

	public Order buildOrder(Collection<Good> goods);
}
