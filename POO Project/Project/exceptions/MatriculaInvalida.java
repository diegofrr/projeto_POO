package exceptions;

public class MatriculaInvalida extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public MatriculaInvalida() {
		super();
		this.msg = "A matrícula precisa ser composta de 8 ou 11 caracteres";
	}

	public String getMessage() { return this.msg; }
}
