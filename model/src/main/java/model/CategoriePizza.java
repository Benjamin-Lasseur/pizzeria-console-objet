package model;

import java.util.Arrays;
import java.util.Optional;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans viande");
	private String type;

	private CategoriePizza(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
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
}
