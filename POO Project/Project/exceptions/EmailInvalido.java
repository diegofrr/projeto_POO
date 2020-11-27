package exceptions;

public class EmailInvalido extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public EmailInvalido(String email) {
		super();
		this.msg = "O e-mail: "+ email + " é inválido!";	
	}
	
	public String getMessage() { return this.msg; }
}
