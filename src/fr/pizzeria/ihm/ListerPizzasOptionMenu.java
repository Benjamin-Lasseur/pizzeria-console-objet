package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;
import fr.pizzeria.model.Pizza;

/**Classe ListerPizzaOptionMenu étendant la classe OptionMenu
 * Elle permet l'affichage de la liste des pizzas
 * @author ETY5
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	//Construteur
	public ListerPizzasOptionMenu(Scanner sc, PizzaDaoImplementation pizzaDao) {
		super(sc, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	//Méthode execute() affichant les pizzas
	@Override
	public boolean execute() {
		System.out.println("Liste des pizzas");
		for (Pizza p : pizzaDao.findAllPizzas()) {
			System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "€)");
		}
		System.out.println();
		return false;
	}

	//Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Afficher les pizzas";
	}

}
