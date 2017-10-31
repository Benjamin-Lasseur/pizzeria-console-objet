package exec;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
import dao_api.IPizzaDao;
import ihm.PizzeriaAdminConsoleApp;

public class Launcher {
	/**
	 * Méthode main lancant l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)){
		context.getBean(PizzeriaAdminConsoleApp.class);
		context.getBean(Scanner.class).close();
		context.getBean(IPizzaDao.class).close();
		context.getBean(EntityManagerFactory.class).close();
		}
	}
}
