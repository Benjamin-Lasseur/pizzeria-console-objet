package config;

import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ihm.PizzeriaAdminConsoleApp;

@Configuration
@ComponentScan({ "ihm", "dao_api", "dao_implementation" })
public class Config {

	/**Bean du scanner
	 * @return
	 */
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in).useLocale(Locale.US);
	}

	/**Bean du logger
	 * @return
	 */
	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	}
	
	/**Bean de l'entityManagerFactory
	 * @return
	 */
	@Bean 
	public EntityManagerFactory entityManagerFactory(){
		return Persistence.createEntityManagerFactory("pu_essai");
	}
	
}
