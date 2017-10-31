package ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.StockageException;
import model.CategoriePizza;
import model.Pizza;

/**
 * Classe ModifierPizzaOptionMenu étendant la classe OptionMenu Elle permet
 * l'affichage nécessaire à la modification d'une pizza
 * 
 * @author ETY5
 *
 */
@Service
public class ModifierPizzaOptionMenu extends OptionMenu {

	@Autowired
	private ListerPizzasOptionMenu lPOM;

	// Construteur
	public ModifierPizzaOptionMenu() {
	
	}

	// Méthode execute() affichant les informations nécessaires à la
	// modification d'une pizza
	@Override
	public boolean execute() throws StockageException {
		LOG.info("Mise à jour d'une pizza");
		lPOM.execute();
		String code;
		LOG.info("Quelle pizza voulez vous modifier (Entrez le code ou 99 pour abandonner)?");
		code = sc.next();
		if ("99".equals(code)) {
			LOG.info("Abandon");
		} else {
			LOG.info("Veuillez saisir le nouveau code:");
			String newCode = sc.next();
			LOG.info("Veuillez entrer le nouveau nom:");
			String newNom = sc.next();
			LOG.info("Veuillez entrer le nouveau prix");
			double newPrix = sc.nextDouble();
			String categorie;
			do {
				LOG.info("Veuillez entrer la categorie de la pizza parmis les suivantes");
				for (CategoriePizza cat : CategoriePizza.values()) {
					LOG.info(cat.getType());
				}
				categorie = sc.next();
			} while (!CategoriePizza.exist(categorie));

			Pizza p = new Pizza(newCode, newNom, newPrix, CategoriePizza.returnCategorie(categorie));
			pizzaDao.updatePizza(code, p);
		}
		return true;
	}

	// Méthode retournant le nom de l'option
	@Override
	public String getLibelle() {
		return "Modifier une pizza";
	}
}
