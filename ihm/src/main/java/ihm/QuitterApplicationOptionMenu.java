package ihm;

import org.springframework.stereotype.Controller;

import exception.StockageException;
@Controller
public class QuitterApplicationOptionMenu extends OptionMenu {


	public QuitterApplicationOptionMenu() {
		
	}

	/*
	 * Quitte l'application
	 * 
	 * 
	 */
	@Override
	public boolean execute() throws StockageException {
		LOG.info("Aurevoir \u2639");
		sc.close();
		pizzaDao.close();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		return "Quitter l'application";
	}

}
