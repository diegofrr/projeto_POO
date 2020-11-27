package exceptions;

public class OpcaoInvalida extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public OpcaoInvalida() {
		super();
		this.msg = "Op��o inv�lida!";
	}
	
	public String getMessage() { return this.msg; }
}
