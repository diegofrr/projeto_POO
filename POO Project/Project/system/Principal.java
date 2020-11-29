package system;

import javax.swing.JOptionPane;
import classes.Aluno;
import classes.Curso;
import classes.Professor;
import exceptions.CampoVazio;
import exceptions.OpcaoInvalida;

public class Principal {

	public static void main(String[] args) throws OpcaoInvalida {
		Sistema sistema = new Sistema();
		Menus menu = new Menus();		
		
		while (true) {
			int opcao = menu.menuPrincipal();		

			if (opcao == 1) {
				String matricula = JOptionPane.showInputDialog("Matrícula"); 	if(matricula == null)	continue;
				String senha = JOptionPane.showInputDialog("Senha"); 			if(senha == null) 		continue;
				boolean logou = sistema.login(matricula, senha);		
			
				if (logou) { 						
					Aluno _alunoLogado = sistema.alunoLogado(matricula);
					JOptionPane.showMessageDialog(null, "Olá, " + _alunoLogado.getNome().split(" ")[0] + "! :)");

					while (true) {
						int op = menu.menuSecundario(_alunoLogado);

						if (op == 1) {
							
							try {
								String nome = JOptionPane.showInputDialog("Nome do professor");
								if(nome == null) { continue; }
								else if(nome.equals("") || nome.equals(" ")) {throw new CampoVazio(); }
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
								if(nome == null) {continue;}
								nome = nome.trim().replaceAll("( +)", " ");
								if(nome.equals(""))  { throw new CampoVazio(); }
								Professor _prof = sistema.procurarProfessorPeloNome(nome);
								
								if (_prof == null) {
									JOptionPane.showMessageDialog(null, "Nenhum professor encontrado. Tente novamente");


								} else if (sistema.profAvaliado(_prof)) {
									while (true){
									int opc = menu.menuEstatisticasProfessor();
									if		(opc == 1)  JOptionPane.showMessageDialog(null, _prof.notas());  
									else if	(opc == 2)  JOptionPane.showMessageDialog(null, _prof.comentarios()); 
									else	break;
									}
									
								} else {
									int option = JOptionPane.showConfirmDialog(null, "O professor, " + _prof.getNome()
									+ ", ainda não foi avaliado. Deseja avaliá-lo agora? :)", null , JOptionPane.YES_NO_OPTION);
									
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
							while(true) {
							Curso _cursoAcessado = sistema.escolherCurso();
							if (_cursoAcessado == null) break;
							while(true) {
							int opcaoCurso = menu.menuAcessarCurso(_cursoAcessado);
							if		(opcaoCurso == 1) 	JOptionPane.showMessageDialog(null, sistema.database.listarProfessoresDeCurso(_cursoAcessado));
							else if	(opcaoCurso == 2) 	JOptionPane.showMessageDialog(null, sistema.database.listarAlunosDeCurso(_cursoAcessado));	
							else if	(opcaoCurso == 3) break;
							}
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
							
						}else if (op == 8){
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