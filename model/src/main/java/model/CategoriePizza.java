package model;

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
		boolean exist = false;
		for (CategoriePizza existingType : CategoriePizza.values()) {
			if (type.equals(existingType.getType())) {
				exist = true;
			}
		}
		return exist;
	}
	
	public static CategoriePizza returnCategorie(String categorie){
		CategoriePizza returnedCategory=null;
		for (CategoriePizza existingType : CategoriePizza.values()) {
			if (categorie.equals(existingType.getType())) {
				returnedCategory= existingType;
			}
		}
		return returnedCategory;
	}

}
