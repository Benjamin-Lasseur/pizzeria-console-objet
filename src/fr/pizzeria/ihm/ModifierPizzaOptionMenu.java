package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;
import fr.pizzeria.model.Pizza;

/**Classe ModifierPizzaOptionMenu étendant la classe OptionMenu
 * Elle permet l'affichage nécessaire à la modification d'une pizza
 * @author ETY5
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu {

	//Construteur
	public ModifierPizzaOptionMenu(Scanner sc, PizzaDaoImplementation pizzaDao) {
		super(sc, pizzaDao);
	}

	//Méthode execute() affichant les informations nécessaires à la modification d'une pizza
	@Override
	public boolean execute() {
		String code;
		System.out.println("Quelle pizza voulez vous modifier (Entrez le code ou 99 pour abandonner)?");
		code = sc.next();
		if (code.equals("99")) {
			System.out.println("Abandon");
		} else {
			System.out.println("Veuillez saisir le nouveau code:");
			String newCode = sc.next();
			System.out.println("Veuillez entrer le nouveau nom:");
			String newNom = sc.next();
			System.out.println("Veuillez entrer le nouveau prix");
			double newPrix = sc.nextDouble();
			Pizza newPizza = new Pizza(newCode, newNom, newPrix);
			pizzaDao.updatePizza(code, newPizza);
		}
		return false;
	}

	//Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier une pizza";
	}
}
