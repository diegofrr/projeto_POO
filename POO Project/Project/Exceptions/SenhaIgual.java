package Exceptions;

public class SenhaIgual extends Exception {
	private String msg;
	
	public SenhaIgual() {
		super();
		this.msg = "A senha não pode ser a mesma";	
	}
	
	public String getMessage() { return this.msg; }
}
