package ihm;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import org.slf4j.*;
import dao_implementation.PizzaDaoImplementation;
import exception.StockageException;

/**
 * Represente l'application controlant depuis la console
 * 
 * @author ETY5
 *
 */
public class PizzeriaAdminConsoleApp {

	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	/** Collection d'actions */
	private HashMap<Integer, OptionMenu> option = new HashMap<>();
	/** Création et remplissage du tableau de pizza */
	private PizzaDaoImplementation pizzaDao = new PizzaDaoImplementation();
	/** Scanner pour les entrées clavier (avec séparateur décimal point) */
	private Scanner sc = new Scanner(System.in).useLocale(Locale.US);

	public PizzeriaAdminConsoleApp() {
		// Instanciation des classes de méthodes Suppression, Modification,
		// Ajout et Listage
		option.put(1, new ListerPizzasOptionMenu(sc, pizzaDao));
		option.put(2, new AjouterPizzaOptionMenu(sc, pizzaDao));
		option.put(3, new ModifierPizzaOptionMenu(sc, pizzaDao, option.get(Integer.valueOf(1))));
		option.put(4, new SupprimerPizzaOptionMenu(sc, pizzaDao, option.get(Integer.valueOf(1))));
		option.put(99, new QuitterApplicationOptionMenu(sc, pizzaDao));
		executer();
	}

	public void executer() {
		/** Entier pour le choix de l'utilisateur */
		int choix;
		boolean continuer = true;
		while (continuer) {
			/** Premier affichage du menu au lancement de l'application */
			afficherOptions();
			choix = sc.nextInt();
			if (option.containsKey(Integer.valueOf(choix))) {
				try {
					option.get(Integer.valueOf(choix)).execute();
				} catch (StockageException e) {
					e.getMessage();
				}
			} else {
				LOG.info("Entrez un choix correct");
			}
		}

	}

	private void afficherOptions() {
		LOG.info("****Pizzeria Administration****");
		LOG.info("1." + option.get(1).getLibelle());
		LOG.info("2." + option.get(2).getLibelle());
		LOG.info("3." + option.get(3).getLibelle());
		LOG.info("4." + option.get(4).getLibelle());
		LOG.info("99." + option.get(99).getLibelle());
	}
}
