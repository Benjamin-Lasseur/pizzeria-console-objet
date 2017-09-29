package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;
import fr.pizzeria.ihm.*;

/**
 * Represente l'application controlant depuis la console
 * 
 * @author ETY5
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** Collection d'actions */
		HashMap<Integer, OptionMenu> option = new HashMap<Integer, OptionMenu>();
		/** Entier pour le choix de l'utilisateur */
		int choix;
		/** Création et remplissage du tableau de pizza */
		PizzaDaoImplementation pizzaDao = new PizzaDaoImplementation();
		/** Scanner pour les entrées clavier (avec séparateur décimal point) */
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		// Instanciation des classes de méthodes Suppression, Modification,
		// Ajout et Listage
		option.put(new Integer(1), new ListerPizzasOptionMenu(sc, pizzaDao));
		option.put(new Integer(2), new AjouterPizzaOptionMenu(sc, pizzaDao));
		option.put(new Integer(3), new ModifierPizzaOptionMenu(sc, pizzaDao));
		option.put(new Integer(4), new SupprimerPizzaOptionMenu(sc, pizzaDao));
		/** Boolean pour quitter l'application */
		boolean continuer = true;
		do {
			/** Premier affichage du menu au lancement de l'application */
			System.out.println("****Pizzeria Administration****");
			System.out.println("1." + option.get(new Integer(1)).getLibelle());
			System.out.println("2." + option.get(new Integer(2)).getLibelle());
			System.out.println("3." + option.get(new Integer(3)).getLibelle());
			System.out.println("4." + option.get(new Integer(4)).getLibelle());
			System.out.println("99.Quitter");
			choix = sc.nextInt();
			try {
				switch (choix) {
				/** Choix 1: Afficher l'ensemble des pizzas */
				case 1:
					option.get(new Integer(1)).execute();
					break;
				/** Choix 2: Ajout d'une nouvelle pizza */
				case 2:
					option.get(new Integer(2)).execute();
					break;
				// Choix 3: Mise à jour d'une pizza
				case 3:
					System.out.println("Mise à jour d'une pizza");
					option.get(new Integer(1)).execute();
					option.get(new Integer(3)).execute();
					break;
				// Choix 4: Suppression d'une pizza
				case 4:
					System.out.println("Supression d'une pizza");
					option.get(new Integer(1)).execute();
					System.out.println("Quelle pizza voulez vous supprimer (Entrez le code ou 99 pour abandonner)?");
					option.get(new Integer(4)).execute();
					break;
				/** Quitter le programme */
				case 99:
					System.out.println("Aurevoir \u2639");
					continuer = false;
					break;
				/** Mauvaise entrée de l'utilisateur */
				default:
					System.out.println("Entrez un choix correct");
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		} while (continuer);
		sc.close();
	}
}
