package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;
import fr.pizzeria.model.Pizza;

/**Classe AjouterPizzaOptionMenu étendant la classe OptionMenu
 * Elle permet l'affichage nécessaire à l'ajout d'une pizza
 * @author ETY5
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu {

	//Construteur
	public AjouterPizzaOptionMenu(Scanner sc, PizzaDaoImplementation pizzaDao) {
		super(sc, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	//Méthode execute() affichant les informations nécessaires à l'ajout d'une pizza
	@Override
	public boolean execute() {
		String code;
		String nom;
		double prix;
		System.out.println("Ajout d'une nouvelle pizza\nVeuillez saisir son code:");
		code = sc.next();
		System.out.println("Veuillez entrer le nom:");
		nom = sc.next();
		System.out.println("Veuillez entrer le prix");
		prix = sc.nextDouble();
		Pizza p = new Pizza(code, nom, prix);
		pizzaDao.saveNewPizza(p);
		return false;
	}

	//Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Ajouter une pizza";
	}

}
