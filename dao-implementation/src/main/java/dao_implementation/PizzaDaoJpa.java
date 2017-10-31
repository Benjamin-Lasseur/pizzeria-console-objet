package dao_implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao_api.IPizzaDao;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import model.Pizza;

@Repository
public class PizzaDaoJpa implements IPizzaDao {

	/** emf : EntityManagerFactory */

	EntityManagerFactory emf;
	/** em : EntityManager */
	EntityManager em;

	@Autowired
	public PizzaDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		connect();
		List<Pizza> pizzas = em.createQuery("select p from Pizza p", Pizza.class).getResultList();
		closeEm();
		return pizzas;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#saveNewPizza(model.Pizza)
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		boolean succes = true;
		connect();
		em.getTransaction().begin();
		em.persist(pizza);
		em.getTransaction().commit();
		closeEm();
		return succes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#updatePizza(java.lang.String, model.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		connect();
		Pizza p = em.createQuery("select p from Pizza p where p.code=:code", Pizza.class)
				.setParameter("code", codePizza).getSingleResult();
		if (p != null) {
			em.getTransaction().begin();
			fusePizza(p, pizza);
			em.merge(p);
			em.getTransaction().commit();
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		connect();
		Pizza p = em.createQuery("select p from Pizza p where p.code=:code", Pizza.class)
				.setParameter("code", codePizza).getSingleResult();
		if (p != null) {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	/**
	 * Création de l'entityManager
	 */
	private void connect() {
		em = emf.createEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#close()
	 */
	public void close() {
		emf.close();
	}

	/**
	 * Fermeture de l'entity Manager
	 */
	private void closeEm() {
		em.close();
	}

	/**
	 * Insertion des nouvelles données de la pizza pour la modification
	 * 
	 * @param origin
	 * @param modification
	 */
	private void fusePizza(Pizza origin, Pizza modification) {
		origin.setCategorie(modification.getCategorie());
		origin.setCode(modification.getCode());
		origin.setNom(modification.getNom());
		origin.setPrix(modification.getPrix());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao_api.IPizzaDao#initialiser(java.util.List)
	 */
	@Override
	public void initialiser(List<Pizza> pizzas) {
		connect();
		em.getTransaction().begin();
		em.createQuery("select p from Pizza p", Pizza.class).getResultList().stream().forEach(p -> em.remove(p));
		pizzas.stream().forEach(p -> em.persist(p));
		em.getTransaction().commit();
		closeEm();

	}

	/**
	 * @return the emf
	 */
	public EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * @param emf
	 *            the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em
	 *            the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
