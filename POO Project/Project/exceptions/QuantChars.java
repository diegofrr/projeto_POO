package exceptions;

public class QuantChars extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public QuantChars(String dado, int quant) {
		super();
		this.msg = dado + " precisa ter pelo menos "+ quant + " caracteres!";	
	}
	
	public String getMessage() { return this.msg; }
}
