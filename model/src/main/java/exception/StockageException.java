package exception;

public class StockageException extends Exception {
	
	/** serialVersionUID : long */
	private static final long serialVersionUID = -2114867832046339229L;

	/**Constructeur de l'exception
	 * @param msg
	 */
	public StockageException(String msg) {
		super(msg);
	}
}
