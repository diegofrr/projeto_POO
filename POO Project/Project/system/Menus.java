package system;

import javax.swing.JOptionPane;

import classes.Aluno;
import classes.Curso;
import interfaces.InterfaceMenus;
import exceptions.OpcaoInvalida;

public class Menus implements InterfaceMenus {
	
	public static final String ERRO_OPCAO_INVALIDA = "Opção inválida!";
	
	public int menuPrincipal(){
		Object[] opcoes = { "FAZER LOGIN", "SE CADASTRAR"};
		int op = JOptionPane.showOptionDialog(null, "Bem-vindo!", "OpUnion", JOptionPane.DEFAULT_OPTION, 1, null, opcoes, opcoes[0]);
		if		(op+1 == 1) 	return 1;
		else if	(op+1 == 2) 	return 2;
		else 					return 3;
	}
	
	public int menuSecundario(Aluno _alunoLogado){
		while(true) {
			try {
				String opcao = JOptionPane.showInputDialog(	"• " + _alunoLogado.getNome().split(" ")[0] + " ("+ _alunoLogado.getMatricula() +")\n\n" +

													"1. AVALIAR PROFESSOR \n"+
													"2. VER ESTATÍSTICAS DE UM PROFESSOR \n"+
													"3. ACESSAR CURSO \n" +
													"4. LISTAR PROFESSORES \n" +
													"5. LISTAR CURSOS \n"+
													"6. RANKING DOS PROFESSORES \n" +
													"7. MEUS DADOS \n\n" +
													"CLIQUE EM CANCELAR PARA SAIR");
				
				if (opcao == null) return 8;
				int opcaoInt = Integer.parseInt(opcao);
				if (opcaoInt < 1 || opcaoInt > 7) throw new OpcaoInvalida(); 
				return opcaoInt;
				
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
				String opcao = JOptionPane.showInputDialog("Curso: " + _cursoAcessado.getNome() + "\n\n" +

													"1. LISTAR PROFESSORES \n"+
													"2. LISTAR ALUNOS \n\n"+
													"CLIQUE EM CANCELAR PARA VOLTAR");
				if(opcao == null) return 3;
				int opcaoInt = Integer.parseInt(opcao);
				if (opcaoInt < 1 || opcaoInt > 2) throw new OpcaoInvalida();
				return opcaoInt;
				
				
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
				String opcao = JOptionPane.showInputDialog(	"1. NOTAS \n"+
															"2. COMENTÁRIO DOS ALUNOS \n\n"+
															"CLIQUE EM CANCELAR PARA VOLTAR");
				if(opcao == null) return 3;
				int opcaoInt = Integer.parseInt(opcao);
				if (opcaoInt < 1 || opcaoInt > 2) throw new OpcaoInvalida();
				return opcaoInt;
				
				
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
				String opcao = JOptionPane.showInputDialog(	"1. DADOS PESSOAIS \n"+
																			"2. MINHAS AVALIAÇÕES \n"+
																			"3. ATUALIZAR SENHA \n" +
																			"4. ATUALIZAR E-MAIL \n\n" +
																			"CLIQUE EM CANCELAR PARA VOLTAR");
				if(opcao == null) return 5;
				int opcaoInt = Integer.parseInt(opcao);
				if (opcaoInt < 1 || opcaoInt > 4) throw new OpcaoInvalida();
				return opcaoInt;
				
				
			} catch ( OpcaoInvalida ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			
			
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ERRO_OPCAO_INVALIDA);
			}
		
		
		}
	}

}
