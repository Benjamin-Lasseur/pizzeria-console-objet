package exec;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
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
		}
	}
}
