package Exceptions;

public class SenhaIgual extends Exception {
	private String msg;
	
	public SenhaIgual() {
		super();
		this.msg = "A senha n�o pode ser a mesma";	
	}
	
	public String getMessage() { return this.msg; }
}
