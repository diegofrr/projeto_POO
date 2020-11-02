package System;

import javax.swing.JOptionPane;

import Class.Aluno;
import Class.Curso;
import Class.Professor;
import Database.Database;

public class Principal {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Menus menu = new Menus();

		while (true) {
			String opcao = menu.menuPrincipal();

			if (opcao.equals("1")) {
				String matricula = JOptionPane.showInputDialog("Matrícula");
				String senha = JOptionPane.showInputDialog("Senha");
				Aluno _alunoLogado = sistema.alunoLogado(matricula);
				boolean logou = sistema.login(matricula, senha);
				if (logou) {
					JOptionPane.showMessageDialog(null, "Bem vindo, " + _alunoLogado.getNome() + "!");

					// DEPOIS DO ALUNO LOGAR NO SISTEMA
					while (true) {
						String op = menu.menuSecundario(_alunoLogado);

						if (op.equals("1")) {
							String nome = JOptionPane.showInputDialog("Nome do professor");
							Professor _prof = sistema.procurarProfessorPeloNome(nome);
							if (_prof == null) {
								JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente.");
							} else {
								sistema.avaliarProfessor(_alunoLogado, _prof);

							}

						} else if (op.equals("2")) {
							String nome = JOptionPane.showInputDialog("Nome do professor");
							Professor _prof = sistema.procurarProfessorPeloNome(nome);

							if (_prof == null) {
								JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente");

							} else {
								if (sistema.profAvaliado(_prof)) {
									JOptionPane.showMessageDialog(null, _prof.notas());

								} else {
									JOptionPane.showMessageDialog(null, "O professor, " + _prof.getNome()
											+ ", ainda não foi avaliado. Que tal avalia-lo? :)");
								}

							}

						} else if (op.equals("3")) {
							String nome = JOptionPane.showInputDialog("Nome do professor");
							Professor _prof = sistema.procurarProfessorPeloNome(nome);
							
							if (_prof == null) {
								JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente");

							} else {
								if (sistema.profAvaliado(_prof)) {
									JOptionPane.showMessageDialog(null, _prof.comentarios());
									
								} else {
									JOptionPane.showMessageDialog(null, "O professor, " + _prof.getNome()
											+ ", ainda não foi avaliado. Que tal avalia-lo? :)");
								}
								
							}
									

						} else if (op.equals("4")) {
							Curso _cursoAcessado = sistema.escolherCurso();
							if (_cursoAcessado == null) continue;
							String opcaoCurso = menu.menuAcessarCurso(_cursoAcessado);
							if(opcaoCurso.equals("1")) {
								JOptionPane.showMessageDialog(null, sistema.database.listarProfessoresDeCurso(_cursoAcessado));
								
							}else if(opcaoCurso.equals("2")) {
								JOptionPane.showMessageDialog(null, sistema.database.listarAlunosDeCurso(_cursoAcessado));
								
							}
							
						} else if (op.equals("5")) {
							JOptionPane.showMessageDialog(null, sistema.database.listarProfessores());
							
							
						} else if (op.equals("6")) {
							JOptionPane.showMessageDialog(null, sistema.database.listarCursos());
							
							
						} else if (op.equals("7")){
							break;
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Falha no login. Tente novamente.");
				}

			} else if (opcao.equals("2")) {
				boolean cadastrou = sistema.cadastrarAluno();
				if (cadastrou) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}

			} else {
				break;
			}
		}
	}
}