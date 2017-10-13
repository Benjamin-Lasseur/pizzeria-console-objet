package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao_api.IPizzaDao;
import exception.StockageException;

public class QuitterApplicationOptionMenu extends OptionMenu {

	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public QuitterApplicationOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
	}

	@Override
	public boolean execute() throws StockageException {
		LOG.info("Aurevoir \u2639");
		sc.close();
		System.exit(0);
		return false;
	}

	@Override
	public String getLibelle() {
		return "Quitter l'application";
	}

}
