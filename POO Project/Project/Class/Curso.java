package Class;

import java.util.ArrayList;

public class Curso {
	
	private String nome;
	private String codigo;
	ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
	
	public Curso(String _nome, String _codigo) {
		this.nome = _nome;
		this.codigo = _codigo;
	}
	
	public Curso() {
		this.nome = "";
		this.codigo = "";
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
