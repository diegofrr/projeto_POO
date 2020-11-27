package exceptions;

public class NotaInvalida extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public NotaInvalida () {
		super();
		this.msg = "Por favor, informe uma nota entre 0 e 10";	
	}
	
	public String getMessage() { return this.msg; }
}
