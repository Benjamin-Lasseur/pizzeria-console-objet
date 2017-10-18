package model;

import java.util.Arrays;
import java.util.Optional;

public enum CategoriePizza {
	VIANDE("Viande", 1), POISSON("Poisson", 2), SANS_VIANDE("Sans viande", 3);
	/** type : String */
	private String type;
	/** id : int */
	private int id;

	/**
	 * Constructeur privé
	 * 
	 * @param type
	 * @param id
	 */
	private CategoriePizza(String type, int id) {
		this.type = type;
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return
	 */
	public int getid() {
		return id;
	}

	/**
	 * Méthode vérifiant si le type fournit en entrée existe
	 * 
	 * @param type
	 * @return
	 */
	public static boolean exist(String type) {
		return Arrays.stream(CategoriePizza.values()).filter(typeExistant -> type.equals(typeExistant.getType()))
				.findAny().isPresent();
	}

	/**
	 * Fournit un object CategoriePizza à partir de la string fournie en entrée
	 * 
	 * @param categorie
	 * @return
	 */
	public static CategoriePizza returnCategorie(String categorie) {
		CategoriePizza cat = null;
		Optional<CategoriePizza> opCat = Arrays.stream(CategoriePizza.values())
				.filter(typeExistant -> typeExistant.getType().equals(categorie)).findFirst();
		if (opCat.isPresent()) {
			cat = opCat.get();
		}
		return cat;
	}

	/**
	 * Fournit un object CategoriePizza à partir de l'int fournie en entrée
	 * 
	 * @param id
	 * @return
	 */
	public static CategoriePizza returnCategorie(int id) {
		CategoriePizza cat = null;
		Optional<CategoriePizza> opCat = Arrays.stream(CategoriePizza.values())
				.filter(typeExistant -> typeExistant.getid() == id).findFirst();
		if (opCat.isPresent()) {
			cat = opCat.get();
		}
		return cat;

	}
}
