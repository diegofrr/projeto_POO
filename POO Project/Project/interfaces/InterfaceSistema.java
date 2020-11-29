package interfaces;


import classes.Aluno;
import classes.Curso;
import classes.Professor;

public interface InterfaceSistema {
	
	public Curso escolherCurso();
	public Professor procurarProfessorPeloNome(String nome);
	public Aluno alunoLogado(String matricula);
	public String rankingProfessores();
	public String dadosPessoais(Aluno alunoLogado);
	public boolean login(String matricula, String senha);
	public boolean cadastrarAluno();
	public boolean notaValida(double nota);
	public boolean verificaAvaliou(String matricula, Professor prof);
	public boolean profAvaliado(Professor _prof);
	public boolean contemNumero(String nome);
	public boolean contemLetra(String matricula);
	public void avaliarProfessor(Aluno _aluno, Professor prof);
	public void atualizarSenha(Aluno alunoLogado);
	public void atualizarEmail(Aluno alunoLogado);
	public void avaliacoesFeitas(Aluno aluno);

}
