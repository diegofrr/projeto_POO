package Exceptions;

public class CampoVazio extends Exception {
	private String msg;
	
	public CampoVazio() {
		super();
		this.msg = "O campo n�o pode ficar vazio";
	}
	
	public String getMessage() { return this.msg; }
}
