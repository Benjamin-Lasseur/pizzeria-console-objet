package ihm;


import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao_api.IPizzaDao;


/**
 * Classe ListerPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage de la liste des pizzas
 * 
 * @author ETY5
 *
 */
@Controller
public class ListerPizzasOptionMenu extends OptionMenu {
	// Construteur
	@Autowired
	public ListerPizzasOptionMenu(Scanner sc, IPizzaDao pizzaDao, Logger LOG) {
		super(sc,pizzaDao,LOG);

	}

	// Méthode execute() affichant les pizzas
	@Override
	public boolean execute() {
		LOG.info("Liste des pizzas");
		pizzaDao.findAllPizzas().stream().forEach(p -> LOG.info(p.toString()));
		return true;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {

		return "Afficher les pizzas";
	}

}
