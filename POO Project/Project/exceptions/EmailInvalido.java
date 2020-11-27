package exceptions;

public class EmailInvalido extends Exception {
	private String msg;
	
	public EmailInvalido(String email) {
		super();
		this.msg = "O e-mail: "+ email + " é inválido!";	
	}
	
	public String getMessage() { return this.msg; }
}
