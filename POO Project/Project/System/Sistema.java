package System;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import Class.Aluno;
import Class.Avaliacao;
import Class.Curso;
import Class.Professor;
import Database.Database;
import Exceptions.CampoVazio;
import Exceptions.ContemEspacos;
import Exceptions.ContemNumero;
import Exceptions.EmailIgual;
import Exceptions.EmailInvalido;
import Exceptions.MatriculaInvalida;
import Exceptions.NotaInvalida;
import Exceptions.QuantCaracteres;
import Exceptions.SenhaIgual;
import Interfaces.InterfaceSistema;

public class Sistema implements InterfaceSistema {
	Database database = new Database();
	
	// ESCOLHE UM CURSO DISPONÍVEL
	public Curso escolherCurso() {
		ArrayList<Curso> listaCursos = database.getListaCursos();
		Object[] cursos = new Object[listaCursos.size()];
		for (int k = 0; k < listaCursos.size(); k++) { cursos[k] = listaCursos.get(k); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Curso", "Opção", JOptionPane.INFORMATION_MESSAGE, null, cursos, cursos[0]);
		return (Curso) valorSelecionado;	
	}

	public boolean contemNumero(String nome) {
		if(	nome.contains("1") || nome.contains("2") || nome.contains("3") ||
			nome.contains("4") || nome.contains("5") || nome.contains("6") ||
			nome.contains("7") || nome.contains("8") || nome.contains("9")) {return true;}
		return false;
	}

	// CADASTRA ALUNO
	public boolean cadastrarAluno() {
		try {
		String nome = JOptionPane.showInputDialog("Nome completo").trim().replaceAll("( +)", " ");
		if(contemNumero(nome))					{ throw new ContemNumero();}
		if(nome == null || nome.equals(" "))	{ throw new CampoVazio();}
		else if(nome.length() < 10) 			{ throw new QuantCaracteres("O nome", 10); }


		String matricula = JOptionPane.showInputDialog("Matrícula").trim().replaceAll("( +)", "");
		if(matricula == null || matricula.equals(" "))	{ throw new CampoVazio(); }
		else if(matricula.length() != 8) 				{ throw new MatriculaInvalida(); }
		for (Aluno _aluno : database.getListaAlunos()) {
			if (_aluno.getMatricula().equals(matricula)) {
				JOptionPane.showMessageDialog(null, "Matrícula já cadastrada no sistema");
				return false;
			}
		}
		
		String email = JOptionPane.showInputDialog("E-mail").trim().replaceAll("( +)", "");
		if(email == null || email.equals(" "))	{ throw new CampoVazio(); }
		else if(email.contains(" "))			{ throw new ContemEspacos("O e-mail"); }
		else if(!email.contains("@gmail.com") 	&&
				!email.contains("@outlook.com") &&
				!email.contains("@hotmail.com") &&
				!email.contains("@dcx.ufpb.br")){ throw new EmailInvalido(email); }
		

		String senha = JOptionPane.showInputDialog("Senha de acesso (mín. 6 caracteres)");
		if(senha.length() < 6) 						{ throw new QuantCaracteres("A senha", 6); }
		else if(senha.contains(" ")) 				{ throw new ContemEspacos("A senha"); }
		else if(senha == null || senha.equals(" ")) { throw new CampoVazio(); }

		Curso curso = this.escolherCurso();
		Aluno aluno = new Aluno(nome, matricula, email, senha, curso);
		database.getListaAlunos().add(aluno);
		curso.adicionarAluno(aluno);
		return true;

		}catch(QuantCaracteres ex){
			JOptionPane.showMessageDialog(null, ex.getMessage()); return false;
		}catch(ContemEspacos ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage()); return false;
		}catch(EmailInvalido ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage()); return false;
		}catch(CampoVazio ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage()); return false;
		}catch(MatriculaInvalida ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage()); return false;
		}catch(ContemNumero ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage()); return false;
		} catch(Exception ex) { return false;
		}
	}


	// PROCURA UM PROFESSOR PELO NOME
	public Professor procurarProfessorPeloNome(String nome) {
		ArrayList<Professor> profEncontrados = new ArrayList<Professor>();
		for (Professor _prof : database.getListaProfessores()) {
			if (_prof.getNome().toUpperCase().contains(nome.toUpperCase())) {
				profEncontrados.add(_prof);
			}
		}
		
		if (profEncontrados.size() == 0) { return null; }
		else if (profEncontrados.size() == 1) {
			JOptionPane.showMessageDialog(null, "1 professor encontrado \n\n" + profEncontrados.get(0).toString());
			return profEncontrados.get(0);
		}


		while (true) {
			
			Object[] professores = new Object[profEncontrados.size()];
			for (int k = 0; k < profEncontrados.size(); k++) { professores[k] = profEncontrados.get(k); }
			Object selectedValue = JOptionPane.showInputDialog(null, profEncontrados.size() 
					+ " professores encontrados. \nEscolha um:", "Opção", JOptionPane.INFORMATION_MESSAGE, null, professores, professores[0]);
			return (Professor) selectedValue;
			
		
			}
	}
	

	// TESTA SE EXISTE LOGIN NO BANCO DE DAOS
	public boolean login(String matricula, String senha) {
		for (Aluno _aluno : database.getListaAlunos()) {
			if (_aluno.getMatricula().equals(matricula) && _aluno.getSenha().equals(senha)) return true;	
		}
		return false;
	}

	// ALUNO FAZ AVALIAÇÃO DE UM DETERMINADO PROFESSOR

	// verifica se o aluno já avaliou o professor em questão
	public void avaliarProfessor(Aluno _aluno, Professor prof) {
		while (true) {
			boolean avaliou = this.verificaAvaliou(_aluno.getMatricula(), prof);

			// caso já tenha avaliado, é printada uma mensagem de aviso e aplicado um break
			// para finalizar o laço, encerrando também o método
			if (avaliou) {
				JOptionPane.showMessageDialog(null, "Você já avaliou este professor!");
				break;
			}

			// aqui se segue o código caso o aluno ainda não tenha avaliado o professor
			try {
				JOptionPane.showMessageDialog(null, "LEIA COM ATENÇÃO! \n"
						+ "a. Você está entrando na aba de avaliação do prof. " + prof.getNome() + "\n"
						+ "b. Informe as notas a seguir de 0 a 10, sendo 0 péssimo e 10 ótimo \n"
						+ "c. Caso queira sair do espaço de avaliação, pressione cancelar mais a seguir");

				double notaMetodologiaEnsino = Double.parseDouble(JOptionPane.showInputDialog("Metodologia de ensino"));
				if (!notaValida(notaMetodologiaEnsino)) { throw new NotaInvalida();}
				
				double notaQualMateriais = Double.parseDouble(JOptionPane.showInputDialog("Qualidade dos materiais"));
				if (!notaValida(notaQualMateriais)) { throw new NotaInvalida();}
				
				double notaInteracaoTurma = Double.parseDouble(JOptionPane.showInputDialog("Interação com a turma"));
				if (!notaValida(notaInteracaoTurma)) { throw new NotaInvalida();}
				
				double notaFidelidadeMaterial = Double.parseDouble(JOptionPane.showInputDialog("Fiderelidade do prof. com o material"));
				if (!notaValida(notaFidelidadeMaterial)) { throw new NotaInvalida();}
				
				double notaRecomendacao = Double.parseDouble(JOptionPane.showInputDialog("Quanto você recomenda o professor"));
				if (!notaValida(notaRecomendacao)) { throw new NotaInvalida();}
				
				String mensagem = null;
				boolean alunoAnonimo = false;
				
				int dxMensagem = JOptionPane.showConfirmDialog(null, "Deseja deixar um comentário sobre o professor?", null, JOptionPane.YES_NO_OPTION);

				
				if (dxMensagem == 0) {
					int anonimo = JOptionPane.showConfirmDialog(null, "Comentar anonimamente?", null, JOptionPane.YES_NO_OPTION);
					if(anonimo == 0) { alunoAnonimo = true; }
					mensagem = JOptionPane.showInputDialog("Seu comentário");
					
					try {
						if (mensagem == null) {
							throw new CampoVazio();
						}
					}catch (CampoVazio ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
				} 
				
				Avaliacao _avaliacao = new Avaliacao(notaMetodologiaEnsino, notaQualMateriais, notaInteracaoTurma, notaFidelidadeMaterial, notaRecomendacao, mensagem, _aluno, prof, alunoAnonimo);
				JOptionPane.showMessageDialog(null, "Avaliação feita com sucesso, obrigado!");
				prof.adicionarAvaliacao(_avaliacao);
				_aluno.adicionarAvaliacao(_avaliacao);
				break;

				// chamada de erro caso o aluno não informe um número nos inputs das notas mais
				// acima
			} catch (NumberFormatException  ex) {
				JOptionPane.showMessageDialog(null,
						"Por favor, informe apenas números");
				break;

			} catch (NotaInvalida ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			} catch (Exception ex) {
				break;
			}
		}

	}

	// MÉTODO RETORNA O ALUNO LOGADO NO SISTEMA
	// recebe a mátricula do aluno do tipo String;
	// testa em cada elemento do tipo Aluno no ArrayList<Aluno> na Database se
	// getMatricula() equivale a String matricula passada no método;
	public Aluno alunoLogado(String matricula) {
		for (Aluno _aluno : database.getListaAlunos()) {
			if (_aluno.getMatricula().equals(matricula)) {
				// caso encontre, retorna o Aluno;
				return _aluno;
			}
		}
		return null;
	}

	// VERIFICA SE AS NOTAS ATRIBUÍDAS ESTÃO ENTRE 0 E 10
	public boolean notaValida(double nota) {
		if (nota < 0 || nota > 10) {
			return false;
		}
		return true;

	}
	
	// PRINTA AS AVALIAÇÕES FEITAS PELO ALUNO RECEBIDO NO PARÂMETRO
	public void avaliacoesFeitas(Aluno aluno) {
		ArrayList<Avaliacao> listaAvaliacoes = aluno.getAvaliacoes();
		if(listaAvaliacoes.size() == 0) {JOptionPane.showMessageDialog(null, "Você ainda não avaliou nenhum professor!"); return;}
		Object[] professores = new Object[listaAvaliacoes.size()];
		for (int k = 0; k < listaAvaliacoes.size(); k++) { professores[k] = listaAvaliacoes.get(k).getProfessor(); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Você avaliou "+ listaAvaliacoes.size() + " professor(es).", "Opção", JOptionPane.INFORMATION_MESSAGE, null, professores, professores[0]);
		Professor prof = (Professor) valorSelecionado;
		for(Avaliacao avaliacao : listaAvaliacoes) {
			if(avaliacao.getProfessor().equals(prof)) JOptionPane.showMessageDialog(null, avaliacao.toString());
		}
	}
	

	// VERIFICA SE ALUNO JA AVALIOU UM PROFESSOR
	public boolean verificaAvaliou(String matricula, Professor prof) {
		for (Avaliacao _avaliacao : prof.getAvaliacoesRecebidas()) {
			if (_avaliacao.getAluno().getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;
	}

	// VERIFICA SE UM PROFESSOR TEM ALGUMA AVALIAÇÃO
	public boolean profAvaliado(Professor _prof) {
		if (_prof.getAvaliacoesRecebidas().size() == 0) {
			return false;
		}
		return true;
	}

	// VOLTA UMA STRING CONTENDO O RANKING DOS PROFESSORES
	public String rankingProfessores() {
		String ranking = "";
		int cont = 1;
		ArrayList<Professor> listaProfessoresAvaliados = new ArrayList<Professor>();
		for (Professor _prof : database.getListaProfessores()) {
			if (this.profAvaliado(_prof)) {
				listaProfessoresAvaliados.add(_prof);
			}
		}

		// CASO NENHUM PROFESSOR ESTEJA SIDO AVALIADO AINDA
		if (listaProfessoresAvaliados.size() == 0) {
			return "Nenhum professor foi avaliado ainda";
		}

		while (true) {
			double maiorNota = 0;
			Professor profMaiorNota = new Professor();
			for (Professor _prof : listaProfessoresAvaliados) {
				if (_prof.calculaMediaGeral() >= maiorNota) {
					maiorNota = _prof.calculaMediaGeral();
					profMaiorNota = _prof;
				}
			}
			ranking += cont++ + "º | " + profMaiorNota.getNome() + " (" + profMaiorNota.getMatricula() + ") " + "Média geral: " + profMaiorNota.calculaMediaGeral() + "\n";
			if (listaProfessoresAvaliados.size() == 1) { return ranking;}
			listaProfessoresAvaliados.remove(profMaiorNota);

			
		}

	}
	
	// RETORNA UMA LISTA COM OS DADOS PESSOAS DO ALUNO RECEBIDO NO PARÂMETRO
	public String dadosPessoais(Aluno alunoLogado) {
		return 	"Nome: " + alunoLogado.getNome() + "\n" +
				"Matrícula: " + alunoLogado.getMatricula() + "\n" +
				"E-mail: " + alunoLogado.getEmail() + "\n" +
				"Curso: " + alunoLogado.getCurso().getNome();
	}
	
	// ATUALIZA A SENHA DO ALUNO RECEBIDO NO PARÂMETRO
	// O MÉTODO EXIGE A CONFIRMAÇÃO DA SENHA ATUAL PARA PODER PROSSEGUIR PARA A ATTUALIZAÇÃO DA SENHA
	public void atualizarSenha(Aluno alunoLogado) {
		String confirmarSenha = JOptionPane.showInputDialog("Confirme sua senha atual");
		if(!confirmarSenha.equals(alunoLogado.getSenha())) {JOptionPane.showMessageDialog(null, "A senha não confere!"); return;}
		
		try {
			String novaSenha = JOptionPane.showInputDialog("Nova senha").trim().replaceAll("( +)", "");
			if(novaSenha.length() < 6) 							throw new QuantCaracteres("A senha", 6); 
			else if(novaSenha.equals(alunoLogado.getSenha())) 	throw new SenhaIgual();
			else alunoLogado.setSenha(novaSenha); JOptionPane.showMessageDialog(null, "Senha alterada com sucesso\n"
																					+ "Sua nova senha é: " + novaSenha);
			
		}catch(QuantCaracteres ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}catch(SenhaIgual ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	
	// ATUALIZA O E-MAIL DO ALUNO RECEBIDO NO PARÂMETRO
	// O SISTEMA EXIGE QUE O ALUNO FORNEÇA UM E-MAIL VÁLIDO
	public void atualizarEmail(Aluno alunoLogado) {
		try {
			String novoEmail = JOptionPane.showInputDialog("Novo e-mail").trim().replaceAll("( +)", "");
			if(novoEmail.equals(alunoLogado.getEmail())) throw new EmailIgual();
			else if(!novoEmail.contains("@gmail.com") 	&&
					!novoEmail.contains("@outlook.com") &&
					!novoEmail.contains("@hotmail.com") &&
					!novoEmail.contains("@dcx.ufpb.br")) throw new EmailInvalido(novoEmail);
			else alunoLogado.setEmail(novoEmail); JOptionPane.showMessageDialog(null, "E-mail alterado com sucesso\n" 
																					+ "Seu novo e-mail é: " + novoEmail);
		
		}catch(EmailIgual ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}catch(EmailInvalido ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}


}
