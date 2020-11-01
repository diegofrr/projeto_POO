package System;

import javax.swing.JOptionPane;

import Class.Professor;

public class Principal {

	
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		
		JOptionPane.showMessageDialog(null, sistema.listarProfessores());
		
		sistema.cadastrarAluno();
		
		String matricula = JOptionPane.showInputDialog("Matr�cula");
		String senha = JOptionPane.showInputDialog("Senha");
		boolean logou = sistema.login(matricula, senha);
		if(logou) {
			JOptionPane.showMessageDialog(null, "Voc� est� logado no sistema!");
		}else {
			JOptionPane.showMessageDialog(null, "Falha no login! Tente novamente.");
		}
		
		//JOptionPane.showMessageDialog(null, sistema.listarAlunos())
		String nome = JOptionPane.showInputDialog("DIGITE O NOME DO PROFESSOR");
		Professor _professor = 	sistema.procurarProfessorPeloNome(nome);
		JOptionPane.showMessageDialog(null, _professor.toString());
	}
}
