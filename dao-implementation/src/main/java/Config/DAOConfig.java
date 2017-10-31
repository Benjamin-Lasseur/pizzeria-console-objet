package Config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dao_api", "dao_implementation" })
public class DAOConfig {

	/**Bean de l'entityManagerFactory
	 * @return
	 */
	@Bean 
	public EntityManagerFactory entityManagerFactory(){
		return Persistence.createEntityManagerFactory("pu_essai");
	}
}
