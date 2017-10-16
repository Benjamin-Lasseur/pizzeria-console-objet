package model;

import java.util.Arrays;
import java.util.Optional;

public enum CategoriePizza {
	VIANDE("Viande", 1), POISSON("Poisson", 2), SANS_VIANDE("Sans viande", 3);
	private String type;
	private int id;

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

	public int getid() {
		return id;
	}

	public static boolean exist(String type) {
		return Arrays.stream(CategoriePizza.values()).filter(typeExistant -> type.equals(typeExistant.getType()))
				.findAny().isPresent();
	}

	public static CategoriePizza returnCategorie(String categorie) {
		CategoriePizza cat = null;
		Optional<CategoriePizza> opCat = Arrays.stream(CategoriePizza.values())
				.filter(typeExistant -> typeExistant.getType().equals(categorie)).findFirst();
		if (opCat.isPresent()) {
			cat = opCat.get();
		}
		return cat;
	}

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
