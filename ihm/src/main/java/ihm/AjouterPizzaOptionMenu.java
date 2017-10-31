package ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao_api.IPizzaDao;
import exception.SavePizzaException;
import model.CategoriePizza;
import model.Pizza;

/**
 * Classe AjouterPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à l'ajout d'une pizza
 * 
 * @author ETY5
 *
 */

@Controller
public class AjouterPizzaOptionMenu extends OptionMenu {


	
	// Construteur
	@Autowired
	public AjouterPizzaOptionMenu(Scanner sc, IPizzaDao pizzaDao, Logger LOG) {
		super(sc,pizzaDao,LOG);
	}

	// Méthode execute() affichant les informations nécessaires à l'ajout d'une
	// pizza
	@Override
	public boolean execute() throws SavePizzaException {
		String code;
		String nom;
		double prix;
		String categorie;
		LOG.info("Ajout d'une nouvelle pizza\nVeuillez saisir son code:");
		code = sc.next();
		if (code.length() > 3) {
			throw new SavePizzaException("Le code de la pizza doit comporter 3 caractères maximum.");
		}
		LOG.info("Veuillez entrer le nom:");
		nom = sc.next();
		LOG.info("Veuillez entrer le prix");
		prix = sc.nextDouble();
		do {
			LOG.info("Veuillez entrer la categorie de la pizza parmis les suivantes");
			for (CategoriePizza cat : CategoriePizza.values()) {
				LOG.info(cat.getType());
			}
			categorie = sc.next();
		} while (!CategoriePizza.exist(categorie));

		Pizza p = new Pizza(code, nom, prix, CategoriePizza.returnCategorie(categorie));
		pizzaDao.saveNewPizza(p);
		return true;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

}
