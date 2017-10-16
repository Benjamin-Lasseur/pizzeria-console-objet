package dao_implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import model.CategoriePizza;
import model.Pizza;

public class RequetesPizza {

	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(RequetesPizza.class);

	/**
	 * Constructeur privé de RequetePizza
	 */
	private RequetesPizza() {

	}

	/**
	 * Méthode permettant d'executer seulement la requete select
	 * 
	 * @param requete
	 * @return
	 */
	public static List<Pizza> executeQuery(String requete) {
		List<Pizza> pizzas = new ArrayList<>();
		Optional<Connection> connection = Optional.empty();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = connect();
			if (connection.isPresent()) {
				statement = connection.get().prepareStatement(requete);
				result = statement.executeQuery();
				while (result.next()) {
					int id = result.getInt("ID");
					String code = result.getString("CODE");
					String nom = result.getString("NOM");
					double prix = result.getDouble("PRIX");
					CategoriePizza categorie = CategoriePizza.returnCategorie(result.getInt("ID_CAT"));
					pizzas.add(new Pizza(id, code, nom, prix, categorie));
				}
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			try {
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
			try {
				if (connection.isPresent()) {
					connection.get().close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return pizzas;
	}

	/**
	 * Méthode permettant de générer une connection à la base de donnée
	 * 
	 * @return
	 */
	private static Optional<Connection> connect() {
		Optional<Connection> connection = Optional.empty();
		ResourceBundle resourceB = ResourceBundle.getBundle("jdbc");
		try {
			Class.forName(resourceB.getString("driver"));
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage());
		}
		try {
			connection = Optional.ofNullable(DriverManager.getConnection(resourceB.getString("url"),
					resourceB.getString("username"), resourceB.getString("password")));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			LOG.error("Connexion echouée");
		}
		return connection;
	}

	/**
	 * Méthode permettant de générer seulement une requete DELETE
	 * 
	 * @param requete
	 * @param codePizza
	 * @return
	 * @throws DeletePizzaException
	 */
	public static boolean executeUpdate(String requete, String codePizza) throws DeletePizzaException {
		boolean sucess = false;
		Optional<Connection> connection = Optional.empty();
		PreparedStatement statement = null;
		try {
			connection = connect();
			if (connection.isPresent()) {
				statement = connection.get().prepareStatement(requete);
				statement.setString(1, codePizza);
				statement.executeUpdate();
				sucess = true;
			}
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			throw new DeletePizzaException("Erreur lors de la suppression de la pizza!");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
			try {
				if (connection.isPresent()) {
					connection.get().close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return sucess;
	}

	/**
	 * Méthode permettant de générer une requete UPDATE
	 * 
	 * @param requete
	 * @param pizza
	 * @param codePizza
	 * @return
	 * @throws UpdatePizzaException
	 */
	public static boolean executeUpdate(String requete, Pizza pizza, String codePizza) throws UpdatePizzaException {
		boolean sucess = false;
		Optional<Connection> connection = Optional.empty();
		PreparedStatement statement = null;
		try {
			connection = connect();
			if (connection.isPresent()) {
				statement = connection.get().prepareStatement(requete);
				statement.setString(1, pizza.getCode());
				statement.setString(2, pizza.getNom());
				statement.setDouble(3, pizza.getPrix());
				statement.setInt(4, pizza.getCategorie().getid());
				statement.setString(5, codePizza);
				statement.executeUpdate();
				sucess = true;
			}
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			throw new UpdatePizzaException("Erreur lors de la mise à jour de la pizza");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
			try {
				if (connection.isPresent()) {
					connection.get().close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return sucess;
	}

	/**
	 * Méthode permettant de générer une requete INSERT
	 * 
	 * @param requete
	 * @param pizza
	 * @return
	 * @throws SavePizzaException
	 */
	public static boolean executeUpdate(String requete, Pizza pizza) throws SavePizzaException {
		boolean sucess = false;
		Optional<Connection> connection = Optional.empty();
		PreparedStatement statement = null;
		try {
			connection = connect();
			if (connection.isPresent()) {
				statement = connection.get().prepareStatement(requete);
				statement.setString(1, pizza.getCode());
				statement.setString(2, pizza.getNom());
				statement.setDouble(3, pizza.getPrix());
				statement.setInt(4, pizza.getCategorie().getid());
				statement.executeUpdate();
				sucess = true;
			}
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			throw new SavePizzaException("Erreur lors de la sauvegarde de la pizza");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
			try {
				if (connection.isPresent()) {
					connection.get().close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return sucess;
	}
}
