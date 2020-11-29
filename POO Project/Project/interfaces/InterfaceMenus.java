package interfaces;

import classes.Aluno;
import classes.Curso;
import exceptions.OpcaoInvalida;

public interface InterfaceMenus {

	public int menuAcessarCurso(Curso _cursoAcessado);
	public int menuSecundario(Aluno _alunoLogado);
	public int menuPrincipal() throws OpcaoInvalida;
	public int menuEstatisticasProfessor();
	public int menuMeusDados();
	
}
