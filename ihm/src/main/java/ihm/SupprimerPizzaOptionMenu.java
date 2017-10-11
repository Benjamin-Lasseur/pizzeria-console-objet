package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.*;

import dao_api.*;

/**
 * Classe SupprimerPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à la suppression d'une pizza
 * 
 * @author ETY5
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {
	private OptionMenu lPOM;
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	// Construteur
	public SupprimerPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao, OptionMenu lPOM) {
		super(sc, pizzaDao);
		this.lPOM = lPOM;
	}

	// Méthode execute() affichant les informations nécessaires à la suppression
	// d'une pizza
	@Override
	public boolean execute() throws StockageException {
		LOG.info("Supression d'une pizza");
		lPOM.execute();
		String code;
		code = sc.next();
		if ("99".equals(code)) {
			LOG.info("Abandon");
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
