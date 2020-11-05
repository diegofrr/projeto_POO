package Interfaces;

import Class.Aluno;
import Class.Curso;
import Exceptions.OpcaoInvalida;

public interface InterfaceMenus {

	public String menuAcessarCurso(Curso _cursoAcessado);
	public int menuSecundario(Aluno _alunoLogado) throws OpcaoInvalida;
	public int menuPrincipal() throws OpcaoInvalida;
	public String menuEstatisticasProfessor();
	
}
