package dao_implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao_api.IPizzaDao;
import exception.DeletePizzaException;
import exception.UpdatePizzaException;
import model.CategoriePizza;
import model.Pizza;

/**Implementation de l'interface DAO de stockage des pizzas
 * @author ETY5
 *
 */
/** */
public class PizzaDaoImplementation implements IPizzaDao {
	/** Tableau stockant les pizzas */
	private ArrayList<Pizza> tabPizza = new ArrayList<>();

	/** Constructeur de la DAO et ajout des pizzas initiales */
	public PizzaDaoImplementation() {
		super();
		tabPizza.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("FRO", "La 4 Fromages", 12.00, CategoriePizza.SANS_VIANDE));
		tabPizza.add(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		tabPizza.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
	}

	/** Méthode findAllPizza() retournant le tableau de pizzas */
	@Override
	public List<Pizza> findAllPizzas() {
		return tabPizza;
	}

	/**
	 * Méthode saveNewPizza(Pizza pizza) permettant de stocker une nouvelle
	 * pizza dans le tableau
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		if (pizza == null) {
			return false;
		} else {
			tabPizza.add(pizza);
		}
		return true;
	}

	/**
	 * Méthode updatePizza(String codePizza, Pizza pizza) permettant de modifier
	 * une pizza
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		boolean returnBoolean;
		Optional<Pizza> opPizza = findPizza(codePizza);
		if (opPizza.isPresent()) {
			opPizza.get().setCategorie(pizza.getCategorie());
			opPizza.get().setCode(pizza.getCode());
			opPizza.get().setPrix(pizza.getPrix());
			opPizza.get().setNom(pizza.getNom());
			opPizza.get().setId(pizza.getId());
			returnBoolean = true;
		} else {
			opPizza.orElseThrow(() -> new UpdatePizzaException("Ce code pizza n\'existe pas !"));
			returnBoolean = false;
		}
		return returnBoolean;
	}

	/**
	 * Méthode deletePizza(String codePizza) permettant de supprimer une pizza
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		boolean returnBoolean;
		Optional<Pizza> opPizza = findPizza(codePizza);
		if (opPizza.isPresent()) {
			tabPizza.remove(opPizza.get());
			returnBoolean = true;
		} else {
			returnBoolean = false;
			opPizza.orElseThrow(() -> new DeletePizzaException("Ce code pizza n\'existe pas !"));
		}
		return returnBoolean;
	}

	public Optional<Pizza> findPizza(String codePizza) {
		return tabPizza.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
	}

}
