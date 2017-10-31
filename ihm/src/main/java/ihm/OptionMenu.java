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

	protected Scanner sc;

	protected IPizzaDao pizzaDao;
	
	protected Logger LOG;

	// Construteur abstrait appelé depuis les classes filles
	public OptionMenu(Scanner sc, IPizzaDao pizzaDao, Logger LOG) {
		this.sc = sc;
		this.pizzaDao = pizzaDao;
		this.LOG = LOG;
	}

	public abstract boolean execute() throws StockageException;

	public abstract String getLibelle();

}
