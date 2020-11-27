package exceptions;

public class EmailIgual extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public EmailIgual() {
		super();
		this.msg = "O e-mail não pode ser o mesmo";
	}
	
	public String getMessage() { return this.msg; }
}
