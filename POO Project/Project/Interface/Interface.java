package Interface;

import Class.Aluno;
import Class.Curso;
import Class.Professor;

public interface Interface {
	
	public Curso escolherCurso();
	public boolean cadastrarAluno();
	public Professor procurarProfessorPeloNome(String nome);
	public boolean login(String matricula, String senha);
	public void avaliarProfessor(Aluno _aluno, Professor prof);
	public Aluno alunoLogado(String matricula);
	public boolean testarNota(double nota1, double nota2, double nota3, double nota4, double nota5);
	public boolean verificaAvaliou(String matricula, Professor prof);
	public boolean profAvaliado(Professor _prof);

}
