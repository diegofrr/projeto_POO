package Exceptions;

public class OpcaoInvalida extends Exception {
	/**
	 * 
	 */
	private String msg;
	
	
	public OpcaoInvalida() {
		super();
		this.msg = "Op��o inv�lida!";
		
	}
	
	public String getMessage() {
		return this.msg;
	}

}
