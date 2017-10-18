package exception;

public class DeletePizzaException extends StockageException {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 2769821308584269270L;

	/**
	 * Constructeur de l'exception
	 * 
	 * @param msg
	 */
	public DeletePizzaException(String msg) {
		super(msg);
	}
}
