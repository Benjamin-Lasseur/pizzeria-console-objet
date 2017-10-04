package dao_implementation;

import java.util.ArrayList;
import java.util.Optional;

import dao_api.IPizzaDao;
import exception.DeletePizzaException;
import exception.SavePizzaException;
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
	public ArrayList<Pizza> findAllPizzas() {
		return tabPizza;
	}

	/**
	 * Méthode saveNewPizza(Pizza pizza) permettant de stocker une nouvelle
	 * pizza dans le tableau
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		tabPizza.add(pizza);
		return false;
	}

	/**
	 * Méthode updatePizza(String codePizza, Pizza pizza) permettant de modifier
	 * une pizza
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		Optional<Pizza> opPizza = findPizza(codePizza);
		if (opPizza.isPresent()) {
			opPizza.get().setCategorie(pizza.getCategorie());
			opPizza.get().setCode(pizza.getCode());
			opPizza.get().setPrix(pizza.getPrix());
			opPizza.get().setNom(pizza.getNom());
			opPizza.get().setId(pizza.getId());
		} else {
			opPizza.orElseThrow(() -> new UpdatePizzaException("Ce code pizza n\'existe pas !"));
		}
		return false;
	}

	/**
	 * Méthode deletePizza(String codePizza) permettant de supprimer une pizza
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		Optional<Pizza> opPizza = findPizza(codePizza);
		if (opPizza.isPresent()) {
			tabPizza.remove(opPizza.get());
		} else {
			opPizza.orElseThrow(() -> new DeletePizzaException("Ce code pizza n\'existe pas !"));
		}
		return false;
	}

	public Optional<Pizza> findPizza(String codePizza) {
		return tabPizza.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
	}

}
