package ihm;

import java.util.Scanner;

import exception.*;

import model.*;

import dao_api.*;

/**
 * Classe SupprimerPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à la suppression d'une pizza
 * 
 * @author ETY5
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {

	// Construteur
	public SupprimerPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	// Méthode execute() affichant les informations nécessaires à la suppression
	// d'une pizza
	@Override
	public boolean execute() throws StockageException {
		String code;
		code = sc.next();
		if ("99".equals(code)) {
			System.out.println("Abandon");
		} else {
			pizzaDao.deletePizza(code);
		}
		return false;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}
}
