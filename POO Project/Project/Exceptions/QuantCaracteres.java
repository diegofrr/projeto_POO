package Exceptions;

public class QuantCaracteres extends Exception {
	/**
	 * 
	 */
	private String msg;
	
	
	public QuantCaracteres(int quant) {
		super();
		this.msg = "A senha precisa ter pelo menos "+ quant + " caracteres!";
		
	}
	
	public String getMessage() {
		return this.msg;
	}

}
