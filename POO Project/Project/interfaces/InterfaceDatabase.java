package interfaces;

import classes.Curso;

public interface InterfaceDatabase {

	// N�o adicionado os m�todos get's e set's
	public String listarAlunosDeCurso(Curso _curso);
	public String listarProfessoresDeCurso(Curso _curso);
	public String listarCursos();
	public String listarProfessores();
	
	
	
}
