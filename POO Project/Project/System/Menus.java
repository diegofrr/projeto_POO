package System;

import javax.swing.JOptionPane;

import Class.Aluno;
import Class.Curso;

public class Menus {
	
	
	public String menuPrincipal() {
		while(true) {
			String opcao = JOptionPane.showInputDialog(	"1. LOGAR NO SISTEMA \n" +
														"2. SE CADASTRAR \n"+
														"3. FECHAR PROGRAMA");

			if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3")) {
				return opcao;
			}
			JOptionPane.showMessageDialog(null, "Por favor, escolha uma opção válida!");
			
			}
	}
	
	public String menuSecundario(Aluno _alunoLogado) {
		while(true) {
		String opcao = JOptionPane.showInputDialog(	"• " + _alunoLogado.getNome() + " ("+ _alunoLogado.getMatricula() +")\n\n" +

													"1. AVALIAR PROFESSOR \n"+
													"2. VER ESTATÍSTICAS DE UM PROFESSOR \n"+
													"3. VER COMENTÁRIOS DE UM PROFESSOR \n"+
													"4. ACESSAR CURSO \n" +
													"5. LISTAR PROFESSORES \n" +
													"6. LISTAR CURSOS \n"+
													"7. ENCERRAR SESSÃO");

		if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5") || opcao.equals("6") || opcao.equals("7")) {
			return opcao;
		}
		JOptionPane.showMessageDialog(null, "Por favor, escolha uma opção válida!");
		
		}

	}
	
	public String menuAcessarCurso(Curso _cursoAcessado) {
		while(true) {
			String opcao = JOptionPane.showInputDialog(	"Curso: " + _cursoAcessado.getNome() + " \n" +
														"1. LISTAR PROFESSORES \n"+
														"2. LISTAR ALUNOS \n" +
														"3. VOLTAR AO MENU PRINCIPAL");

			if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3")) {
				return opcao;
			}
			JOptionPane.showMessageDialog(null, "Por favor, escolha uma opção válida!");
			
			}
	}
}
