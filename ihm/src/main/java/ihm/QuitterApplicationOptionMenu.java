package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao_api.IPizzaDao;
import exception.StockageException;
@Controller
public class QuitterApplicationOptionMenu extends OptionMenu {


	@Autowired
	public QuitterApplicationOptionMenu(Scanner sc, IPizzaDao pizzaDao, Logger LOG) {
		super(sc,pizzaDao,LOG);	
	}

	/*
	 * Quitte l'application
	 * 
	 * 
	 */
	@Override
	public boolean execute() throws StockageException {
		LOG.info("Aurevoir \u2639");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		return "Quitter l'application";
	}

}
