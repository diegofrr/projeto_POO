package exceptions;

public class CampoVazio extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public CampoVazio() {
		super();
		this.msg = "O campo não pode ficar vazio";
	}
	
	public String getMessage() { return this.msg; }
}
