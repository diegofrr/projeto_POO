package Class;

public class Aluno extends Pessoa {

	private Curso curso;
	private String senha;
	
	public Aluno(String _nome, String _matricula, String _email, String _senha) {
		super(_nome, _matricula, _email);
		this.senha = _senha;
	}
	
	public Aluno() {
		super();
		this.senha = "";
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String _senha) {
		this.senha = _senha;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso _curso) {
		this.curso = _curso;
	}
	
	public String toString() {
		return "Nome: " + getNome() + "\n" 
				+ "Matrícula: " + getMatricula() + "\n"
				+ getCurso().toString();
		
	}

	
}
