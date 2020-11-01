package Class;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Professor extends Pessoa{
	private ArrayList<Curso>  listaCursos = new ArrayList<Curso>();
	private ArrayList<Avaliacao> avaliacao;
	
	public Professor(String _nome, String _matricula, String _email, ArrayList<Curso> _cursos, ArrayList<Avaliacao> _avaliacao) {
		super(_nome, _matricula, _email);
		for(Curso _curso : _cursos) {
			listaCursos.add(_curso);
		}
		this.avaliacao = _avaliacao;
		
	}
	
	public Professor() {
		super();
		this.listaCursos = new ArrayList<Curso>();

		
	
	}

	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}
	
	public void setListaCursos(ArrayList<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	public String listarCursos() {
		String lista = "";
		for(Curso _curso : listaCursos) {
			lista += _curso.toString();
		}
		
	
		return lista;
		
	}
	
	public String toString() {
		return "Nome: " + getNome() + "\n"
				+ "Matrícula: " + getMatricula() + "\n"
				+ "E-mail: " + getEmail() + "\n"
				+ "Curso(s): \n" + listarCursos() ;
	}

	public ArrayList<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	

}
