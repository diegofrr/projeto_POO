package System;

import javax.swing.JOptionPane;

public class Menus {
	
	
	public String menuPrincipal() {
		while(true) {
			String opcao = JOptionPane.showInputDialog(	"1. LOGAR NO SISTEMA \n" +
														"2. SE CADASTRAR \n"+
														"3. SAIR");

			if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3")) {
				return opcao;
			}
			JOptionPane.showMessageDialog(null, "Por favor, escolha uma op��o v�lida!");
			
			}
	}
	
	public String menuSecundario() {
		while(true) {
		String opcao = JOptionPane.showInputDialog(	"DIGITE UM OP��O \n"+
													"1. AVALIAR PROFESSOR \n"+
													"2. VER ESTAT�STICAS DE UM PROFESSOR \n"+
													"3. VER COMENT�RIOS DE UM PROFESSOR \n"+
													"4. LISTAR PROFESSORES \n" +
													"5. SAIR");

		if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5")) {
			return opcao;
		}
		JOptionPane.showMessageDialog(null, "Por favor, escolha uma op��o v�lida!");
		
		}

	}
}
