package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao_api.IPizzaDao;
import exception.StockageException;

public class QuitterApplicationOptionMenu extends OptionMenu {

	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	/**
	 * Constructeur
	 * 
	 * @param sc
	 * @param pizzaDao
	 */
	public QuitterApplicationOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
	}

	/*
	 * Quitte l'application
	 * 
	 * 
	 */
	@Override
	public boolean execute() throws StockageException {
		LOG.info("Aurevoir \u2639");
		sc.close();
		pizzaDao.close();
		System.exit(0);
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
