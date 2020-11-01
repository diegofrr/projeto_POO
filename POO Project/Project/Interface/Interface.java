package Interface;

import Class.Curso;
import Class.Professor;

public interface Interface {
	
	public Curso escolherCurso();
	public boolean cadastrarAluno();
	public Professor procurarProfessorPeloNome(String nome);
	public Professor procurarProfessorPelaMatricula(String matricula);
	public String listarProfessores();
}
