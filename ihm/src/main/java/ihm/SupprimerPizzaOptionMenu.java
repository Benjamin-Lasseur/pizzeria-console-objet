package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao_api.IPizzaDao;
import exception.StockageException;

/**
 * Classe SupprimerPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à la suppression d'une pizza
 * 
 * @author ETY5
 *
 */
@Controller
public class SupprimerPizzaOptionMenu extends OptionMenu {

	private ListerPizzasOptionMenu lPOM;

	// Construteur
	@Autowired
	public SupprimerPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao, Logger LOG, ListerPizzasOptionMenu lPOM) {
		super(sc, pizzaDao, LOG);
		this.lPOM = lPOM;
	}

	// Méthode execute() affichant les informations nécessaires à la suppression
	// d'une pizza
	@Override
	public boolean execute() throws StockageException {
		LOG.info("Supression d'une pizza");
		lPOM.execute();
		LOG.info("Entrez le code de la pizza à supprimer (99 pour abandonner)");
		String code;
		code = sc.next();
		if ("99".equals(code)) {
			LOG.info("Abandon");
		} else {
			pizzaDao.deletePizza(code);
		}
		return true;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		return "Supprimer une pizza"; 
	}
}
