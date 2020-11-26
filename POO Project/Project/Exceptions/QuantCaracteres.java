package Exceptions;

public class QuantCaracteres extends Exception {
	/**
	 * 
	 */
	private String msg;
	
	
	public QuantCaracteres(String dado, int quant) {
		super();
		this.msg = dado + " precisa ter pelo menos "+ quant + " caracteres!";
		
	}
	
	public String getMessage() {
		return this.msg;
	}

}
