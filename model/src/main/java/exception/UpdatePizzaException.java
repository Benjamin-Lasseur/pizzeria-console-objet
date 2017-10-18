package exception;

public class UpdatePizzaException extends StockageException{

	
	/** serialVersionUID : long */
	private static final long serialVersionUID = -5682149591857278420L;

	/**Constructeur de l'exception
	 * @param msg
	 */
	public UpdatePizzaException(String msg){
		super(msg);
	}
}
