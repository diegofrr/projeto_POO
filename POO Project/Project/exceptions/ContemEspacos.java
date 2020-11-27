package exceptions;

public class ContemEspacos extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ContemEspacos(String dado) {
		super();
		this.msg = dado +" não pode conter espaços";	
	}
	
	public String getMessage() { return this.msg; }
}
