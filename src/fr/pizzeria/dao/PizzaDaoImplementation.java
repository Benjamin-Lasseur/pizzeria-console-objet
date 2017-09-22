package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**Implementation de l'interface DAO de stockage des pizzas
 * @author ETY5
 *
 */
/** */
public class PizzaDaoImplementation implements IPizzaDao {
	/**Tableau stockant les pizzas*/
	private Pizza[] tabPizza = new Pizza[8];
	/**Constructeur de la DAO et ajout des pizzas initiales */
	public PizzaDaoImplementation() {
		super();
		tabPizza[0] = new Pizza("PEP", "Pépéroni", 12.50);
		tabPizza[1] = new Pizza("MAR", "Margherita", 14.00);
		tabPizza[2] = new Pizza("REIN", "La Reine", 11.50);
		tabPizza[3] = new Pizza("FRO", "La 4 Fromages", 12.00);
		tabPizza[4] = new Pizza("CAN", "La Cannibale", 12.50);
		tabPizza[5] = new Pizza("SAV", "La savoyarde", 13.00);
		tabPizza[6] = new Pizza("ORI", "L'orientale", 13.50);
		tabPizza[7] = new Pizza("IND", "L'indienne", 14.00);
	}

	/**Méthode findAllPizza() retournant le tableau de pizzas */
	@Override
	public Pizza[] findAllPizzas() {
		return tabPizza;
	}

	/**Méthode saveNewPizza(Pizza pizza) permettant de stocker une nouvelle pizza dans le tableau */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		Pizza[] newTabPizza = new Pizza[tabPizza.length + 1];
		for (int i = 0; i < tabPizza.length; i++) {
			newTabPizza[i] = tabPizza[i];
		}
		newTabPizza[newTabPizza.length - 1] = pizza;
		tabPizza=newTabPizza;
		return false;
	}

	/**Méthode updatePizza(String codePizza, Pizza pizza) permettant de modifier une pizza */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i<tabPizza.length; i++) {
			if (tabPizza[i].getCode().equals(codePizza)) {
				tabPizza[i] = pizza;
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
				Pizza[] newTabPizza = new Pizza[tabPizza.length - 1];
				int index = 0;
				int index2 = 0;
				while (index <= tabPizza.length - 1) {
					if (tabPizza[index].getCode().equals(codePizza)) {
						index++;
					} else {
						newTabPizza[index2] = tabPizza[index];
						index2++;
						index++;
					}

				}	
				tabPizza = newTabPizza;
				break;
			}
		}
		return false;
	}

}
