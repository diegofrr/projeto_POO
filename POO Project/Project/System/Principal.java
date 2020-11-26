package System;


import javax.swing.JOptionPane;

import Class.Aluno;
import Class.Curso;
import Class.Professor;
import Exceptions.CampoVazio;
import Exceptions.OpcaoInvalida;

public class Principal {

	public static void main(String[] args) throws OpcaoInvalida {
		Sistema sistema = new Sistema();
		Menus menu = new Menus();
		
		while (true) {
			int opcao = menu.menuPrincipal();

			if (opcao == 1) {
				String matricula = JOptionPane.showInputDialog("Matr�cula");
				String senha = JOptionPane.showInputDialog("Senha");
				boolean logou = sistema.login(matricula, senha);		
			
				if (logou) { 						
					Aluno _alunoLogado = sistema.alunoLogado(matricula);
					JOptionPane.showMessageDialog(null, "Bem vindo, " + _alunoLogado.getNome().split(" ")[0] + "!");

					
					// DEPOIS DO ALUNO LOGAR NO SISTEMA
					while (true) {
						int op = menu.menuSecundario(_alunoLogado);

						if (op == 1) {
							
							try {
								String nome = JOptionPane.showInputDialog("Nome do professor");
								if(nome == null || nome.equals("") || nome.equals(" ")) {throw new CampoVazio(); }
								Professor _prof = sistema.procurarProfessorPeloNome(nome);
								
								if (_prof == null) {
									JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente.");
								} else {
									sistema.avaliarProfessor(_alunoLogado, _prof);

								}
								
							}catch(CampoVazio ex){
								JOptionPane.showMessageDialog(null, ex.getMessage());
							}
	
							

						} else if (op == 2) {
							try {
								String nome = JOptionPane.showInputDialog("Nome do professor");
								if(nome == null || nome.equals(" ")) { throw new CampoVazio(); }
								Professor _prof = sistema.procurarProfessorPeloNome(nome);
								
								if (_prof == null) {
									JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente");


								} else if (sistema.profAvaliado(_prof)) {
									int opc = menu.menuEstatisticasProfessor();
									
									if (opc == 1) { JOptionPane.showMessageDialog(null, _prof.notas()); }
									else if (opc == 2) { JOptionPane.showMessageDialog(null, _prof.comentarios()); }
									else { continue; }
									
								} else {
									int option = JOptionPane.showConfirmDialog(null, "O professor, " + _prof.getNome()
									+ ", ainda n�o foi avaliado. Deseja avali�-lo agora? :)", null , JOptionPane.YES_NO_OPTION);
									
									if (option == 0) {
										sistema.avaliarProfessor(_alunoLogado, _prof);

									} else {
										continue;
									}
								}
								
								
								
							}catch(CampoVazio ex) {
								JOptionPane.showMessageDialog(null, ex.getMessage());
							}
							
							
								 	

						} else if (op == 3) {
							Curso _cursoAcessado = sistema.escolherCurso();
							if (_cursoAcessado == null) continue;
							int opcaoCurso = menu.menuAcessarCurso(_cursoAcessado);
							if(opcaoCurso == 1) {
								JOptionPane.showMessageDialog(null, sistema.database.listarProfessoresDeCurso(_cursoAcessado));
								
							}else if(opcaoCurso == 2) {
								JOptionPane.showMessageDialog(null, sistema.database.listarAlunosDeCurso(_cursoAcessado));
								
							} 
							
						} else if (op == 4) {
							JOptionPane.showMessageDialog(null, sistema.database.listarProfessores());
							
							
						} else if (op == 5) {
							JOptionPane.showMessageDialog(null, sistema.database.listarCursos());
							
							
						} else if (op == 6) {
							JOptionPane.showMessageDialog(null, sistema.rankingProfessores());													
							
						}
						
						
						else if (op == 7) {
							while(true) {
							
							int opcaoDados = menu.menuMeusDados();
							if(opcaoDados == 1) { 
								JOptionPane.showMessageDialog(null, sistema.dadosPessoais(_alunoLogado));
							} else if(opcaoDados == 2) {
								sistema.avaliacoesFeitas(_alunoLogado);
							
							} else if(opcaoDados == 3) {
								sistema.atualizarSenha(_alunoLogado);
								
							} else if(opcaoDados == 4) {
								sistema.atualizarEmail(_alunoLogado);
							}
							
							
							else if(opcaoDados == 5){ break; }
								
								
							}
							
						}
						
						
						
						
						else if (op == 8){
							break;
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Falha no login. Tente novamente.");
				}

			} else if (opcao == 2) {
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