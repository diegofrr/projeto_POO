package classes;

import java.util.ArrayList;

public class Aluno extends Pessoa {

	private Curso curso;
	private String senha;
	private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	
	public Aluno(String _nome, String _matricula, String _email, String _senha, Curso _curso) {
		super(_nome, _matricula, _email);
		this.senha = _senha;
		this.curso = _curso;
	}
	
	public Aluno() {
		super();
		this.senha = "";
		this.curso = new Curso();
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
	
	public ArrayList<Avaliacao> getAvaliacoes(){
		return this.avaliacoes;
	}
	
	public void adicionarAvaliacao(Avaliacao av) {
		this.avaliacoes.add(av);
	}
	
	public String toString() {
		return "Nome: " + getNome() + "\n" 
				+ "Matr�cula: " + getMatricula() + "\n"
				+ getCurso().toString();
		
	}

	
}
