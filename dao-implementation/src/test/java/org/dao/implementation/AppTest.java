package org.dao.implementation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao_implementation.PizzaDaoImplementation;
import dao_implementation.PizzaDaoJDBC;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import model.CategoriePizza;
import model.Pizza;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoJDBC.class);

	/**
	 * Test non passant supprimant une pizza dont le code n'existe pas dans la
	 * dao
	 * 
	 * @throws Exception
	 */
	@Test(expected = DeletePizzaException.class)
	public void testDeletePizzaNonPassant() throws Exception {
		String codePizza = "jhg";
		PizzaDaoImplementation pDI = new PizzaDaoImplementation();
		pDI.deletePizza(codePizza);
	}

	/**
	 * Test non passant supprimant une pizza dont le code existe pas dans la dao
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeletePizzaPassant() throws Exception {
		String codePizza = "PEP";
		PizzaDaoImplementation pDI = new PizzaDaoImplementation();
		boolean ok = pDI.deletePizza(codePizza);
		assertTrue(ok);
	}

	/**
	 * Test passant d'ajout de pizza vérifiant que la taille de la collection de
	 * pizza à augmenter de 1
	 */
	@Test
	public void testSavePizza() {
		CategoriePizza categorie = CategoriePizza.POISSON;
		String code = "GFD";
		String nom = "Grande Fraiche Delicieuse";
		double prix = 12.30;
		PizzaDaoImplementation pDI = new PizzaDaoImplementation();
		int nbPizzaDebut = pDI.findAllPizzas().size();
		Pizza p = new Pizza(code, nom, prix, categorie);
		try {
			pDI.saveNewPizza(p);
		} catch (SavePizzaException e) {
			LOG.debug(e.getMessage());
		}
		assert (pDI.findAllPizzas().size() == nbPizzaDebut + 1);
		assertThat(pDI.findAllPizzas().size(), is(equals(nbPizzaDebut + 1)));
	}

	/**
	 * Test non passant d'ajout d'une pizza null
	 */
	@Test
	public void testSavePizzaNonPassant() {
		Pizza p = null;
		PizzaDaoImplementation pDI = new PizzaDaoImplementation();
		try {
			assertFalse(pDI.saveNewPizza(p));
		} catch (SavePizzaException e) {
			LOG.debug(e.getMessage());
		}
	}

	/**
	 * Test passant de modification d'une pizza
	 * 
	 * @throws Exception
	 */
	@Test
	public void testModifier() throws Exception {
		String codeAModifier = "PEP";
		CategoriePizza categorie = CategoriePizza.POISSON;
		String code = "GFD";
		String nom = "Grande Fraiche Delicieuse";
		double prix = 12.30;
		PizzaDaoImplementation pDI = new PizzaDaoImplementation();
		Pizza p = new Pizza(code, nom, prix, categorie);
		pDI.updatePizza(codeAModifier, p);
		assertTrue(pDI.findPizza(code).isPresent());
		assertFalse(pDI.findPizza(codeAModifier).isPresent());
	}
}
