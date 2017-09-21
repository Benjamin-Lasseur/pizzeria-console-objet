package fr.pizzeria.console;

import java.util.Locale;
import java.util.Scanner;
import fr.pizzeria.model.*;

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
		/**
		 * Chaine de caractère pour stocker les codes tapés par l'utilisateur
		 */
		String code;
		/** Chaine de caractère pour stocker les noms tapés par l'utilisateur */
		String nom;
		/** Double pour stocker les prix tapés par l'utilisateur */
		double prix;
		/** Création et remplissage du tableau de pizza */
		Pizza[] tabPizza = new Pizza[8];
		tabPizza[0] = new Pizza("PEP", "Pépéroni", 12.50);
		tabPizza[1] = new Pizza("MAR", "Margherita", 14.00);
		tabPizza[2] = new Pizza("REIN", "La Reine", 11.50);
		tabPizza[3] = new Pizza("FRO", "La 4 Fromages", 12.00);
		tabPizza[4] = new Pizza("CAN", "La Cannibale", 12.50);
		tabPizza[5] = new Pizza("SAV", "La savoyarde", 13.00);
		tabPizza[6] = new Pizza("ORI", "L'orientale", 13.50);
		tabPizza[7] = new Pizza("IND", "L'indienne", 14.00);
		/** Scanner pour les entrées clavier (avec séparateur décimal point) */
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		/** Boolean pour quitter l'application */
		boolean continuer = true;
		do {
			/** Premier affichage du menu au lancement de l'application */
			System.out.println(
					"****Pizzeria Administration****\n1. Lister les pizzas\n2. Ajouter une nouvelle pizza\n3. Mettre à jour une pizza\n4. Supprimer une pizza\n99. Sortir");
			choix = sc.nextInt();
			switch (choix) {
			/** Choix 1: Afficher l'ensemble des pizzas */
			case 1:
				PizzeriaAdminConsoleApp.afficherPizza(tabPizza);
				break;
			/** Choix 2: Ajout d'une nouvelle pizza */
			case 2:
				System.out.println("Ajout d'une nouvelle pizza\nVeuillez saisir son code:");
				code = sc.next();
				System.out.println("Veuillez entrer le nom:");
				nom = sc.next();
				System.out.println("Veuillez entrer le prix");
				prix = sc.nextDouble();
				Pizza[] newTabPizza = new Pizza[tabPizza.length + 1];
				for (int i = 0; i < tabPizza.length; i++) {
					newTabPizza[i] = tabPizza[i];
				}
				newTabPizza[newTabPizza.length - 1] = new Pizza(code, nom, prix);
				tabPizza = newTabPizza;
				break;
			// Choix 3: Mise à jour d'une pizza
			case 3:
				System.out.println("Mise à jour d'une pizza");
				PizzeriaAdminConsoleApp.afficherPizza(tabPizza);
				System.out.println("Quelle pizza voulez vous modifier (Entrez le code ou 99 pour abandonner)?");
				code = sc.next();
				if (code.equals("99")) {
					System.out.println("Abandon");
				} else {
					for (Pizza p : tabPizza) {
						if (p.getCode().equals(code)) {
							System.out.println("Veuillez saisir le nouveau code:");
							p.setCode(sc.next());
							System.out.println("Veuillez entrer le nouveau nom:");
							p.setNom(sc.next());
							System.out.println("Veuillez entrer le nouveau prix");
							p.setPrix(sc.nextDouble());
							break;
						}
					}
				}
				break;
			// Choix 4: Suppression d'une pizza
			case 4:
				System.out.println("Suppression d'une pizza");
				PizzeriaAdminConsoleApp.afficherPizza(tabPizza);
				System.out.println("Quelle pizza voulez vous supprimer (Entrez le code ou 99 pour abandonner)?");
				code = sc.next();
				if (code.equals("99")) {
					System.out.println("Abandon");
				} else {
					for (Pizza p : tabPizza) {
						if (p.getCode().equals(code)) {
							Pizza[] newTabPizza2 = new Pizza[tabPizza.length - 1];
							int index = 0;
							int index2 = 0;
							while (index <= 7) {
								if (tabPizza[index].getCode().equals(code)) {
									index++;
								} else {
									newTabPizza2[index2] = tabPizza[index];
									index2++;
									index++;
								}

							}
							tabPizza = newTabPizza2;
							break;
						}
					}
				}
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
		} while (continuer);
		sc.close();
	}

	/**Méthode permettant d'afficher la liste des pizzas
	 * @param tabPizza
	 */
	static public void afficherPizza(Pizza[] tabPizza) {
		System.out.println("Liste des pizzas");
		for (Pizza p : tabPizza) {
			System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "€)");
		}
	}

}
