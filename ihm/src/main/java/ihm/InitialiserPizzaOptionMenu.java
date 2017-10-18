package ihm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao_api.IPizzaDao;
import exception.StockageException;
import model.CategoriePizza;
import model.Pizza;

public class InitialiserPizzaOptionMenu extends OptionMenu {

	/** tabPizzaInit : List<Pizza> */
	List<Pizza> tabPizzaInit = new ArrayList<>();

	/**
	 * Constructeur
	 * 
	 * @param sc
	 * @param pizzaDao
	 */
	public InitialiserPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao) {
		super(sc, pizzaDao);
	}

	/*
	 * Créer les pizzas et invoque la méthode de la dao insérant les nouvelles
	 * pizzas
	 * 
	 */
	@Override
	public boolean execute() throws StockageException {
		tabPizzaInit.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		tabPizzaInit.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		tabPizzaInit.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		tabPizzaInit.add(new Pizza("FRO", "La 4 Fromages", 12.00, CategoriePizza.SANS_VIANDE));
		tabPizzaInit.add(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		tabPizzaInit.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		tabPizzaInit.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		tabPizzaInit.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
		pizzaDao.initialiser(tabPizzaInit);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		return "Initialiser les pizzas";
	}

}
