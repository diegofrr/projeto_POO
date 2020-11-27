package interfaces;

import classes.Curso;

public interface InterfaceDatabase {

	// Não adicionado os métodos get's e set's
	public String listarAlunosDeCurso(Curso _curso);
	public String listarProfessoresDeCurso(Curso _curso);
	public String listarCursos();
	public String listarProfessores();
	
	
	
}
