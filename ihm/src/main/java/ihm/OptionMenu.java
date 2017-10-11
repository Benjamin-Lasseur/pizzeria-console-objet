package ihm;

import java.util.Scanner;

import exception.*;


import dao_api.*;

/**Classe abstraite généralisant les différentes options
 * @author ETY5
 *
 */
public abstract class OptionMenu {
	/**
	 * Scanner sc Scanner d'entrée clavier
	 * PizzaDaoImplementation pizzaDao DAO de stockage des pizzas
	 */
	protected Scanner sc;
	protected IPizzaDao pizzaDao;
	

	public abstract boolean execute() throws StockageException;

	public abstract String getLibelle();

	//Construteur abstrait appelé depuis les classes filles
	public OptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		this.sc = sc;
		this.pizzaDao = pizzaDao;
	}
}
