package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**Implementation de l'interface DAO de stockage des pizzas
 * @author ETY5
 *
 */
/** */
public class PizzaDaoImplementation implements IPizzaDao {
	/**Tableau stockant les pizzas*/
	private ArrayList<Pizza> tabPizza = new ArrayList<>();
	/**Constructeur de la DAO et ajout des pizzas initiales */
	public PizzaDaoImplementation() {
		super();
		tabPizza.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("FRO", "La 4 Fromages", 12.00, CategoriePizza.SANS_VIANDE));
		tabPizza.add(new Pizza("CAN", "La Cannibale", 12.50,CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		tabPizza.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
	}

	/**Méthode findAllPizza() retournant le tableau de pizzas */
	@Override
	public ArrayList<Pizza> findAllPizzas() {
		return tabPizza;
	}

	/**Méthode saveNewPizza(Pizza pizza) permettant de stocker une nouvelle pizza dans le tableau */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		tabPizza.add(pizza);
		return false;
	}

	/**Méthode updatePizza(String codePizza, Pizza pizza) permettant de modifier une pizza */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i<tabPizza.size(); i++) {
			if (tabPizza.get(i).getCode().equals(codePizza)) {
				tabPizza.set(i, pizza);
				break;
			}
		}
		return false;
	}

	/**Méthode deletePizza(String codePizza) permettant de supprimer une pizza */
	@Override
	public boolean deletePizza(String codePizza) {
		for (Pizza p : tabPizza) {
			if (p.getCode().equals(codePizza)) {
				tabPizza.remove(p);
				break;
			}
		}
		return false;
	}

}
