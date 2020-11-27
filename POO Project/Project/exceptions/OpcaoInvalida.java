package exceptions;

public class OpcaoInvalida extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public OpcaoInvalida() {
		super();
		this.msg = "Opção inválida!";
	}
	
	public String getMessage() { return this.msg; }
}
