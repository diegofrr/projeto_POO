package system;

import javax.swing.JOptionPane;

import classes.Aluno;
import classes.Curso;
import interfaces.InterfaceMenus;
import exceptions.OpcaoInvalida;

public class Menus implements InterfaceMenus {
	
	public static final String ERRO_OPCAO_INVALIDA = "Opção inválida!";
	
	public int menuPrincipal(){
		Object[] options = { "ENTRAR", "SE CADASTRAR"};
		int op = JOptionPane.showOptionDialog(null, "Teacher Evaluation System", "Bem vindo!", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
		if		(op+1 == 1) 	return 1;
		else if	(op+1 == 2) 	return 2;
		else 					return 3;
	}
	
	public int menuSecundario(Aluno _alunoLogado){
		while(true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(	"• " + _alunoLogado.getNome().split(" ")[0] + " ("+ _alunoLogado.getMatricula() +")\n\n" +

													"1. AVALIAR PROFESSOR \n"+
													"2. VER ESTATÍSTICAS DE UM PROFESSOR \n"+
													"3. ACESSAR CURSO \n" +
													"4. LISTAR PROFESSORES \n" +
													"5. LISTAR CURSOS \n"+
													"6. RANKING DOS PROFESSORES \n" +
													"7. MEUS DADOS \n" +
													"8. DESLOGAR"));
				if (opcao < 1 || opcao > 8) {
					throw new OpcaoInvalida();
				} return opcao;
				
				
			} catch ( OpcaoInvalida ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ERRO_OPCAO_INVALIDA);
			}
		
		
		}

	}
	
	public int menuAcessarCurso(Curso _cursoAcessado){
		while(true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Curso: " + _cursoAcessado.getNome() + "\n\n" +

													"1. LISTAR PROFESSORES \n"+
													"2. LISTAR ALUNOS \n"+
													"3. VOLTAR AO MENU PRINCIPAL"));
				if (opcao < 1 || opcao > 3) {
					throw new OpcaoInvalida();
				} return opcao;
				
				
			} catch ( OpcaoInvalida ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ERRO_OPCAO_INVALIDA);
			}
		
		
		}
	}
	
	public int menuEstatisticasProfessor(){
		while(true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(	"1. NOTAS \n"+
																			"2. COMENTÁRIOS DOS ALUNOS \n"+
																			"3. VOLTAR"));
				if (opcao < 1 || opcao > 3) {
					throw new OpcaoInvalida();
				} return opcao;
				
				
			} catch ( OpcaoInvalida ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ERRO_OPCAO_INVALIDA);
			}
		
		
		}
	}

	public int menuMeusDados() {
		while(true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(	"1. DADOS PESSOAIS \n"+
																			"2. MINHAS AVALIAÇÕES \n"+
																			"3. ATUALIZAR SENHA \n" +
																			"4. ATUALIZAR E-MAIL \n" +
																			"5. VOLTAR"));
				if (opcao < 1 || opcao > 5) {
					throw new OpcaoInvalida();
				} return opcao;
				
				
			} catch ( OpcaoInvalida ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ERRO_OPCAO_INVALIDA);
			}
		
		
		}
	}
	
	
	
}
