package ihm;

import java.util.Scanner;

import dao_api.IPizzaDao;
import exception.StockageException;
import model.CategoriePizza;
import model.Pizza;

public class InitialiserPizzaOptionMenu extends OptionMenu {

	public InitialiserPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
	}

	@Override
	public boolean execute() throws StockageException {
		pizzaDao.saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzaDao.saveNewPizza(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzaDao.saveNewPizza(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzaDao.saveNewPizza(new Pizza("FRO", "La 4 Fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzaDao.saveNewPizza(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaDao.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzaDao.saveNewPizza(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		pizzaDao.saveNewPizza(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
		return false;
	}

	@Override
	public String getLibelle() {
		return "Initialiser les pizzas";
	}

}
