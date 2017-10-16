package dao_implementation;

import java.util.List;

import dao_api.IPizzaDao;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import model.Pizza;

public class PizzaDaoJDBC implements IPizzaDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		return RequetesPizza.executeQuery("SELECT * FROM PIZZA");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#saveNewPizza(model.Pizza)
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		return RequetesPizza.executeUpdate("INSERT INTO PIZZA(CODE, NOM, PRIX, CATEGORIE) VALUES (?,?,?,?)", pizza);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#updatePizza(java.lang.String, model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		return RequetesPizza.executeUpdate("UPDATE PIZZA SET CODE=?, NOM=?, PRIX=?, CATEGORIE=? WHERE CODE=?", pizza,
				codePizza);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		return RequetesPizza.executeUpdate("DELETE FROM PIZZA WHERE CODE=?", codePizza);
	}

}
