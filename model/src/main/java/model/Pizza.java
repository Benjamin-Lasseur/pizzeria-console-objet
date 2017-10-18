package model;

import javax.persistence.*;

import utils.StringUtils;
import utils.ToString;

/**
 * Classe définissant une pizza
 * 
 * @author ETY5
 *
 */
@Entity
@Table(name = "pizza")
public class Pizza {
	/** Index de la pizza */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** Code de la pizza */
	@ToString
	@Column(name = "CODE")
	private String code;
	/** Nom de la pizza */
	@ToString(upperCase = true)
	@Column(name = "NOM")
	private String nom;
	/** Prix de la pizza */
	@ToString
	@Column(name = "PRIX")
	private double prix;
	/** Categorie de la pizza */
	@ToString
	@Column(name = "CATEGORIE")
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;

	/**
	 * Constructeur d'hibernate
	 */
	public Pizza() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param code
	 *            code
	 * @param nom
	 *            nom
	 * @param prix
	 *            prix
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            id
	 * @param code
	 *            code
	 * @param nom
	 *            nom
	 * @param prix
	 *            prix
	 * @param categorie
	 *            categorie
	 */
	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return StringUtils.convert(this);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
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
	 * @param nom
	 *            the nom to set
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
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}

	/**
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

}
