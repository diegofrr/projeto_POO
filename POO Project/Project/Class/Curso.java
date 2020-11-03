package Class;

import java.util.ArrayList;

public class Curso {
	
	private String nome;
	private String codigo;
	private ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	public Curso(String _nome, String _codigo) {
		this.nome = _nome;
		this.codigo = _codigo;
	}
	
	public Curso() {
		this.nome = "";
		this.codigo = "";
	}
	
	public void adicionarAluno(Aluno _aluno) {
		this.listaAlunos.add(_aluno);
	}
	
	public ArrayList<Aluno> getListaAlunos(){
		return this.listaAlunos;
	}
	
	public ArrayList<Professor> getListaProfessores(){
		return this.listaProfessores;
	}
	
	public void adicionarProfessor(Professor _prof) {
		this.listaProfessores.add(_prof);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String toString() {
		return getNome() + " (" + getCodigo() + ")" + "\n";

	}
}
