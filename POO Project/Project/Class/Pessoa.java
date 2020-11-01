package Class;

public class Pessoa {
	
	private String nome;
	private String matricula;
	private String email;
	
	public Pessoa(String _nome, String _matricula, String _email) {
		this.nome = _nome;
		this.matricula = _matricula;
		this.email = _email;
	}
	
	public Pessoa() {
		this.setNome("");
		this.setMatricula("");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
