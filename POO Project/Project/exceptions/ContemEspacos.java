package exceptions;

public class ContemEspacos extends Exception {
	private String msg;
	
	public ContemEspacos(String dado) {
		super();
		this.msg = dado +" n�o pode conter espa�os";	
	}
	
	public String getMessage() { return this.msg; }
}
