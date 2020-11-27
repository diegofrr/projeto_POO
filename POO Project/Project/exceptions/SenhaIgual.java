package exceptions;

public class SenhaIgual extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public SenhaIgual() {
		super();
		this.msg = "A senha não pode ser a mesma";	
	}
	
	public String getMessage() { return this.msg; }
}
