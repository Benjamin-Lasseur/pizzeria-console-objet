package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import dao_api.IPizzaDao;
import exception.StockageException;

/**
 * Classe abstraite généralisant les différentes options
 * 
 * @author ETY5
 *
 */

public abstract class OptionMenu {
	/**
	 * Scanner sc Scanner d'entrée clavier PizzaDaoImplementation pizzaDao DAO
	 * de stockage des pizzas
	 */
	@Autowired
	protected Scanner sc;
	@Autowired
	protected IPizzaDao pizzaDao;
	@Autowired
	protected Logger LOG;

	// Construteur abstrait appelé depuis les classes filles
	public OptionMenu() {
	
	}

	public abstract boolean execute() throws StockageException;

	public abstract String getLibelle();

}
