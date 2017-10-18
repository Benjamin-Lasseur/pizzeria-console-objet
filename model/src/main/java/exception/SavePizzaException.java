package exception;

public class SavePizzaException extends StockageException{


	/** serialVersionUID : long */
	private static final long serialVersionUID = -7742084499561652364L;

	/**Constructeur de l'exception
	 * @param msg
	 */
	public SavePizzaException(String msg){
		super(msg);
	}
}
