package Interface;

import Class.Aluno;
import Class.Curso;
import Class.Professor;

public interface Interface {
	
	public Curso escolherCurso();
	public boolean cadastrarAluno();
	public String listarAlunos();
	public Professor procurarProfessorPeloNome(String nome);
	public String listarProfessores();
	public boolean login(String matricula, String senha);
	public void avaliarProfessor(Aluno _aluno, Professor prof);
	public Aluno alunoLogado(String matricula);
	public boolean testarNota(double nota);
	public boolean verificaAvaliou(String matricula, Professor prof);

}
