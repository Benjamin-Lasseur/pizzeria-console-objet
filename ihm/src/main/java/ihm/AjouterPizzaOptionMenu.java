package ihm;

import java.util.Scanner;

import exception.*;

import model.*;

import dao_api.*;

/**
 * Classe AjouterPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à l'ajout d'une pizza
 * 
 * @author ETY5
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu {

	// Construteur
	public AjouterPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	// Méthode execute() affichant les informations nécessaires à l'ajout d'une
	// pizza
	@Override
	public boolean execute() throws SavePizzaException {
		String code;
		String nom;
		double prix;
		String categorie;
		System.out.println("Ajout d'une nouvelle pizza\nVeuillez saisir son code:");
		code = sc.next();
		if (code.length() > 3) {
			throw new SavePizzaException("Le code de la pizza doit comporter 3 caractères maximum.");
		}
		System.out.println("Veuillez entrer le nom:");
		nom = sc.next();
		System.out.println("Veuillez entrer le prix");
		prix = sc.nextDouble();
		do {
			System.out.println("Veuillez entrer la categorie de la pizza parmis les suivantes");
			for (CategoriePizza cat : CategoriePizza.values()) {
				System.out.println(cat.getType());
			}
			categorie = sc.next();
		} while (!CategoriePizza.exist(categorie));

		Pizza p = new Pizza(code, nom, prix, CategoriePizza.returnCategorie(categorie));
		pizzaDao.saveNewPizza(p);
		return false;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Ajouter une pizza";
	}

}
