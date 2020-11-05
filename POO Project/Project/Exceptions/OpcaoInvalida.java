package Exceptions;

public class OpcaoInvalida extends Exception {
	/**
	 * 
	 */
	private String msg;
	
	
	public OpcaoInvalida() {
		super();
		this.msg = "Opção inválida!";
		
	}
	
	public String getMessage() {
		return this.msg;
	}

}
