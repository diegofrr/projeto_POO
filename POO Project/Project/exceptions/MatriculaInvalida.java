package exceptions;

public class MatriculaInvalida extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public MatriculaInvalida() {
		super();
		this.msg = "A matrícula precisa ter 11 caracteres";
	}

	public String getMessage() { return this.msg; }
}
