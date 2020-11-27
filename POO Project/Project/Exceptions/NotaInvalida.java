package Exceptions;

public class NotaInvalida extends Exception {
	private String msg;
	
	public NotaInvalida () {
		super();
		this.msg = "Por favor, informe uma nota entre 0 e 10";	
	}
	
	public String getMessage() { return this.msg; }
}
