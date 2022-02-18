package dao_implementation;

import java.util.ArrayList;
import java.util.List;
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
	/** tabPizza : ArrayList<Pizza> */
	private ArrayList<Pizza> tabPizza = new ArrayList<>();

	/** Constructeur de la DAO et ajout des pizzas initiales */
	/**
	 * 
	 */
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		return tabPizza;
	}

	/**
	 * Méthode saveNewPizza(Pizza pizza) permettant de stocker une nouvelle
	 * pizza dans le tableau
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#saveNewPizza(model.Pizza)
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		boolean sucess = false;
		if (pizza == null) {
			throw new SavePizzaException("Erreur lors de la sauvegarde de la pizza!");
		} else {
			tabPizza.add(pizza);
			sucess = true;
		}
		return sucess;
	}

	/**
	 * Méthode updatePizza(String codePizza, Pizza pizza) permettant de modifier
	 * une pizza
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#updatePizza(java.lang.String, model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		boolean returnBoolean = false;
		Optional<Pizza> opPizza = findPizza(codePizza);
		if (opPizza.isPresent()) {
			opPizza.get().setCategorie(pizza.getCategorie());
			opPizza.get().setCode(pizza.getCode());
			opPizza.get().setPrix(pizza.getPrix());
			opPizza.get().setNom(pizza.getNom());
			opPizza.get().setId(pizza.getId());
			returnBoolean = true;
		} else {
			throw new UpdatePizzaException("Ce code pizza n\'existe pas !");

		}
		return returnBoolean;
	}

	/**
	 * Méthode deletePizza(String codePizza) permettant de supprimer une pizza
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		boolean returnBoolean = false;
		Optional<Pizza> opPizza = findPizza(codePizza);
		if (opPizza.isPresent()) {
			tabPizza.remove(opPizza.get());
			returnBoolean = true;
		} else {
			throw new DeletePizzaException("Ce code pizza n\'existe pas !");
		}
		return returnBoolean;
	}

	/**
	 * @param codePizza
	 * @return
	 */
	public Optional<Pizza> findPizza(String codePizza) {
		return tabPizza.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#close()
	 */
	@Override
	public void close() {
		tabPizza.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#initialiser(java.util.List)
	 */
	@Override
	public void initialiser(List<Pizza> pizzas) {
		tabPizza.clear();
		pizzas.stream().forEach(p -> tabPizza.add(p));

	}

}
