package Exceptions;

public class MatriculaInvalida extends Exception {
	/**
	 * 
	 */
	private String msg;
	
	
	public MatriculaInvalida() {
		super();
		this.msg = "A matrícula precisa ter 8 caracteres";
		
	}
	
	public String getMessage() {
		return this.msg;
	}

}
