package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;
import fr.pizzeria.exception.StockageException;

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
	protected PizzaDaoImplementation pizzaDao;

	public abstract boolean execute() throws StockageException;

	public abstract String getLibelle();

	//Construteur abstrait appelé depuis les classes filles
	public OptionMenu(Scanner sc, PizzaDaoImplementation pizzaDao) {
		this.sc = sc;
		this.pizzaDao = pizzaDao;
	}
}
