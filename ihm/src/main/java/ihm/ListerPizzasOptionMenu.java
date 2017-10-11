package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao_api.*;

/**
 * Classe ListerPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage de la liste des pizzas
 * 
 * @author ETY5
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	// Construteur
	public ListerPizzasOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
	}

	// Méthode execute() affichant les pizzas
	@Override
	public boolean execute() {
		LOG.info("Liste des pizzas");
		pizzaDao.findAllPizzas().stream().forEach(p -> LOG.info(p.toString()));
		return false;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {

		return "Afficher les pizzas";
	}

}
