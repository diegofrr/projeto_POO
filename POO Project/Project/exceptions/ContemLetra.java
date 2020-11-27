package exceptions;

public class ContemLetra extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ContemLetra() {
		super();
		this.msg = "A matr�cula deve ser composta somente por n�meros";	
	}
	
	public String getMessage() { return this.msg; }
}
