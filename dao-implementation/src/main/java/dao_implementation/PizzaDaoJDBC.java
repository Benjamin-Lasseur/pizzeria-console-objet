package dao_implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao_api.IPizzaDao;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import model.Pizza;

public class PizzaDaoJDBC implements IPizzaDao {

	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(RequetesPizza.class);

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
		return RequetesPizza.executeUpdate("INSERT INTO PIZZA(CODE, NOM, PRIX, ID_CAT) VALUES (?,?,?,?)", pizza);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#updatePizza(java.lang.String, model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		return RequetesPizza.executeUpdate("UPDATE PIZZA SET CODE=?, NOM=?, PRIX=?, ID_CAT=? WHERE CODE=?", pizza,
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

	/* (non-Javadoc)
	 * @see dao_api.IPizzaDao#close()
	 */
	@Override
	public void close() {
		// useless here

	}

	/* (non-Javadoc)
	 * @see dao_api.IPizzaDao#initialiser(java.util.List)
	 */
	@Override
	public void initialiser(List<Pizza> pizzas) {
		findAllPizzas().stream().forEach(p -> {
			try {
				deletePizza(p.getCode());
			} catch (DeletePizzaException e) {
				LOG.debug(e.getMessage(), e);
			}
		});
		pizzas.stream().forEach(p -> {
			try {
				saveNewPizza(p);
			} catch (SavePizzaException e) {
				LOG.debug(e.getMessage(), e);
			}
		});
	}

}
