package exceptions;

public class ContemNumero extends Exception {
	private String msg;
	
	public ContemNumero() {
		super();
		this.msg = "O seu nome n�o pode conter n�meros!";	
	}
	
	public String getMessage() { return this.msg;}
}
