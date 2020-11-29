package interfaces;

import classes.Curso;

public interface InterfaceDatabase {

	public String listarAlunosDeCurso(Curso _curso);
	public String listarProfessoresDeCurso(Curso _curso);
	public String listarCursos();
	public String listarProfessores();
	
}
