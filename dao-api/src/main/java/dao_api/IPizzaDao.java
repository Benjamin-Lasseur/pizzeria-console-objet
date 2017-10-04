package dao_api;



import java.util.ArrayList;

import exception.*;
import model.Pizza;

/**Interface permettant de définir la stucture de la DAO stockant les pizzas
 * @author ETY5
 *
 */
public interface IPizzaDao {
	ArrayList<Pizza> findAllPizzas();

	boolean saveNewPizza(Pizza pizza);

	boolean updatePizza(String codePizza, Pizza pizza)throws UpdatePizzaException;

	boolean deletePizza(String codePizza) throws DeletePizzaException;

}
