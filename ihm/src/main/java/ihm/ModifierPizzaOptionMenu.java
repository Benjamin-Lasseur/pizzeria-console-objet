package ihm;

import java.util.Scanner;


import exception.*;

import model.*;

import dao_api.*;

/**
 * Classe ModifierPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à la modification d'une pizza
 * 
 * @author ETY5
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu {

	// Construteur
	public ModifierPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
	}

	// Méthode execute() affichant les informations nécessaires à la
	// modification d'une pizza
	@Override
	public boolean execute() throws UpdatePizzaException {
		String code;
		System.out.println("Quelle pizza voulez vous modifier (Entrez le code ou 99 pour abandonner)?");
		code = sc.next();
		if (code.length() > 3) {
			throw new UpdatePizzaException("Le code rentré n\'est pas valide");
		}
		if ("99".equals(code)) {
			System.out.println("Abandon");
		} else {
			System.out.println("Veuillez saisir le nouveau code:");
			String newCode = sc.next();
			System.out.println("Veuillez entrer le nouveau nom:");
			String newNom = sc.next();
			System.out.println("Veuillez entrer le nouveau prix");
			double newPrix = sc.nextDouble();
			String categorie;
			do {
				System.out.println("Veuillez entrer la categorie de la pizza parmis les suivantes");
				for (CategoriePizza cat : CategoriePizza.values()) {
					System.out.println(cat.getType());
				}
				categorie = sc.next();
			} while (!CategoriePizza.exist(categorie));
			
		Pizza p = new Pizza(newCode, newNom, newPrix, CategoriePizza.returnCategorie(categorie));
		pizzaDao.updatePizza(code, p);
		}
		return false;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier une pizza";
	}
}
