package exceptions;

public class ContemLetra extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ContemLetra() {
		super();
		this.msg = "A matrícula deve ser composta somente por números";	
	}
	
	public String getMessage() { return this.msg; }
}
