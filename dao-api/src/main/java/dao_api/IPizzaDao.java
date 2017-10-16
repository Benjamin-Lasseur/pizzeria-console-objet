package dao_api;

import java.util.List;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import model.Pizza;

/**
 * Interface permettant de définir la stucture de la DAO stockant les pizzas
 * 
 * @author ETY5
 *
 */
public interface IPizzaDao {

	/**
	 * Retourne toutes les pizzas
	 * 
	 * @return
	 */
	List<Pizza> findAllPizzas();

	/**
	 * sauvegarde une nouvelle pizza
	 * 
	 * @param pizza
	 * @return
	 */
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

	/**
	 * Met à jour une pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 * @return
	 * @throws UpdatePizzaException
	 */
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;

	/**
	 * Suprimme une pizza
	 * 
	 * @param codePizza
	 * @return
	 * @throws DeletePizzaException
	 */
	boolean deletePizza(String codePizza) throws DeletePizzaException;

}
