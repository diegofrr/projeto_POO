package exceptions;

public class ContemNumero extends Exception {
	private String msg;
	
	public ContemNumero() {
		super();
		this.msg = "O seu nome não pode conter números!";	
	}
	
	public String getMessage() { return this.msg;}
}
