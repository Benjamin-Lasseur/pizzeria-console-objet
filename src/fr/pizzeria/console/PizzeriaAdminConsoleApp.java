package fr.pizzeria.console;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplementation;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

/**
 * Represente l'application controlant depuis la console
 * 
 * @author ETY5
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** Entier pour le choix de l'utilisateur */
		int choix;
		/** Création et remplissage du tableau de pizza */
		PizzaDaoImplementation pizzaDao = new PizzaDaoImplementation();
		/** Scanner pour les entrées clavier (avec séparateur décimal point) */
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		// Instanciation des classes de méthodes Suppression, Modification,
		// Ajout et Listage
		ModifierPizzaOptionMenu mpom = new ModifierPizzaOptionMenu(sc, pizzaDao);
		SupprimerPizzaOptionMenu spom = new SupprimerPizzaOptionMenu(sc, pizzaDao);
		AjouterPizzaOptionMenu apom = new AjouterPizzaOptionMenu(sc, pizzaDao);
		ListerPizzasOptionMenu lpom = new ListerPizzasOptionMenu(sc, pizzaDao);
		/** Boolean pour quitter l'application */
		boolean continuer = true;
		do {
			/** Premier affichage du menu au lancement de l'application */
			System.out.println("****Pizzeria Administration****");
			System.out.println("1." + lpom.getLibelle());
			System.out.println("2." + apom.getLibelle());
			System.out.println("3." + mpom.getLibelle());
			System.out.println("4." + spom.getLibelle());
			System.out.println("99.Quitter");
			choix = sc.nextInt();
			try {
				switch (choix) {
				/** Choix 1: Afficher l'ensemble des pizzas */
				case 1:
					lpom.execute();
					break;
				/** Choix 2: Ajout d'une nouvelle pizza */
				case 2:
					apom.execute();
					break;
				// Choix 3: Mise à jour d'une pizza
				case 3:
					System.out.println("Mise à jour d'une pizza");
					lpom.execute();
					mpom.execute();
					break;
				// Choix 4: Suppression d'une pizza
				case 4:
					System.out.println("Supression d'une pizza");
					lpom.execute();
					System.out.println("Quelle pizza voulez vous supprimer (Entrez le code ou 99 pour abandonner)?");
					spom.execute();
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
