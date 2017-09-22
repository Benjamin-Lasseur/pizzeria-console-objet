package ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;

/**Classe SupprimerPizzaOptionMenu étendant la classe OptionMenu
 * Elle permet l'affichage nécessaire à la suppression d'une pizza
 * @author ETY5
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {

	//Construteur
	public SupprimerPizzaOptionMenu(Scanner sc, PizzaDaoImplementation pizzaDao) {
		super(sc, pizzaDao);
		// TODO Auto-generated constructor stub
	}

	//Méthode execute() affichant les informations nécessaires à la suppression d'une pizza
	@Override
	public boolean execute() {
		String code;
		code = sc.next();
		if (code.equals("99")) {
			System.out.println("Abandon");
		} else {
			pizzaDao.deletePizza(code);

		}
		return false;
	}

	//Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}
}
