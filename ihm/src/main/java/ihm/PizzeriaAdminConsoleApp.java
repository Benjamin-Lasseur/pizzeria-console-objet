package ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import exception.StockageException;

/**
 * Represente l'application controlant depuis la console
 * 
 * @author ETY5
 *
 */
@Service
public class PizzeriaAdminConsoleApp {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private Logger LOG;

	@Autowired
	private Scanner sc;

	private Map<Integer, OptionMenu> options = new HashMap<>();

	@PostConstruct
	public void init() {
		AtomicInteger increment = new AtomicInteger(0);
		context.getBeansOfType(OptionMenu.class).values().forEach(o -> options.put(increment.incrementAndGet(), o));
		executer();
	}

	public PizzeriaAdminConsoleApp() {
		
	}

	public void executer() {
		/** Entier pour le choix de l'utilisateur */
		int choix;
		boolean continuer = true;
		while (continuer) {
			/** Premier affichage du menu au lancement de l'application */
			afficherOptions();
			choix = sc.nextInt();
			if (options.containsKey(Integer.valueOf(choix))) {
				try {
					continuer = options.get(Integer.valueOf(choix)).execute();
				} catch (StockageException e) {
					LOG.error(e.getMessage(), e);
				}
			} else {
				LOG.info("Entrez un choix correct");
			}
		}

	}

	private void afficherOptions() {
		LOG.info("****Pizzeria Administration****");
		AtomicInteger increment = new AtomicInteger(0);
		options.values().forEach((o) -> LOG.info(increment.incrementAndGet() + "." + o.getLibelle()));

	}
}
