package exceptions;

public class EmailIgual extends Exception {
	private String msg;
	
	public EmailIgual() {
		super();
		this.msg = "O e-mail n�o pode ser o mesmo";
	}
	
	public String getMessage() { return this.msg; }
}
