package ihm;

import java.util.Scanner;


import model.*;

import dao_api.*;
/**Classe ListerPizzaOptionMenu étendant la classe OptionMenu
 * Elle permet l'affichage de la liste des pizzas
 * @author ETY5
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	//Construteur
	public ListerPizzasOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	//Méthode execute() affichant les pizzas
	@Override
	public boolean execute() {
		System.out.println("Liste des pizzas");
		for (Pizza p : pizzaDao.findAllPizzas()) {
			System.out.println(p.toString());
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
