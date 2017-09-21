package fr.pizzeria.model;

/**
 * Classe définissant une pizza
 * 
 * @author ETY5
 *
 */
public class Pizza {
	/** Index static permettant de donner un index unique aux pizzas */
	static int indexId = 1;
	/** Index de la pizza */
	private int id;
	/** Code de la pizza */
	private String code;
	/** Nom de la pizza */
	private String nom;
	/** Prix de la pizza */
	private double prix;

	/**
	 * Constructeur
	 * 
	 * @param code code
	 * @param nom nom
	 * @param prix prix
	 */
	public Pizza(String code, String nom, double prix) {
		this.id = Pizza.indexId;
		Pizza.indexId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	

}
