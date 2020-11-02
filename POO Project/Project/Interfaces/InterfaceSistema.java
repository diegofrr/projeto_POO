package Interfaces;

import java.util.ArrayList;

import Class.Aluno;
import Class.Curso;
import Class.Professor;

public interface InterfaceSistema {
	
	public Curso escolherCurso();
	public Professor procurarProfessorPeloNome(String nome);
	public Aluno alunoLogado(String matricula);
	public String rankingProfessores();
	public boolean login(String matricula, String senha);
	public boolean cadastrarAluno();
	public boolean testarNota(double nota1, double nota2, double nota3, double nota4, double nota5);
	public boolean verificaAvaliou(String matricula, Professor prof);
	public boolean profAvaliado(Professor _prof);
	public void avaliarProfessor(Aluno _aluno, Professor prof);

}
