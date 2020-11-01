package Class;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Professor extends Pessoa{
	private ArrayList<Curso>  listaCursos = new ArrayList<Curso>();
	
	public Professor(String _nome, String _matricula, String _email, ArrayList<Curso> _cursos) {
		super(_nome, _matricula, _email);
		for(Curso _curso : _cursos) {
			listaCursos.add(_curso);
		}
	}
	
	public Professor() {
		super();
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

}
