package exceptions;

public class EmailInvalido extends Exception {
	private String msg;
	
	public EmailInvalido(String email) {
		super();
		this.msg = "O e-mail: "+ email + " � inv�lido!";	
	}
	
	public String getMessage() { return this.msg; }
}
