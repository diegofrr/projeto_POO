package System;

import javax.swing.JOptionPane;

import Class.Professor;

public class Principal {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Menus menu = new Menus();

		while (true) {
			String opcao = menu.menuPrincipal();

			if (opcao.equals("1")) {
				String matricula = JOptionPane.showInputDialog("Matrícula");
				String senha = JOptionPane.showInputDialog("Senha");
				boolean logou = sistema.login(matricula, senha);
				if (logou) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					
					//DEPOIS DO ALUNO LOGAR NO SISTEMA
					while(true) {
					String op = menu.menuSecundario();
					
						if (op.equals("1")) {
							String nome = JOptionPane.showInputDialog("Nome do professor");
							Professor _prof = sistema.procurarProfessorPeloNome(nome);
							if (_prof == null) {
								JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente.");
							}
							
							
							
						} else if (op.equals("2")) {
							
						} else if (op.equals("3")) {
							
						} else if (op.equals("4")) {
							break;
						}
					}
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Falha no login. Tente novamente.");
				}

			}else if (opcao.equals("2")) {
				sistema.cadastrarAluno();
			}else {
				break;
			}
		}
	}
}