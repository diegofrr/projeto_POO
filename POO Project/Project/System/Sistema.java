package System;

import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;
import Class.Aluno;
import Class.Avaliacao;
import Class.Curso;
import Class.Professor;
import Database.Database;
import Exceptions.CampoVazio;
import Exceptions.NotaInvalida;
import Exceptions.OpcaoInvalida;
import Interfaces.InterfaceSistema;

public class Sistema implements InterfaceSistema {
	Database database = new Database();

	public static final String NOME_INVALIDO = "Nome inv�lido!";
	public static final String MATRICULA_INVALIDA = "Matr�cula inv�lida!";
	public static final String EMAIL_INVALIDO = "E-mail inv�lido!";
	public static final String SENHA_INVALIDA = "Senha inv�lida! Por favor, n�o utilize espa�os.";

	
	// ESCOLHE UM CURSO DISPON�VEL
	public Curso escolherCurso() {
		ArrayList<Curso> listaCursos = database.getListaCursos();
		Object[] cursos = new Object[listaCursos.size()];
		for (int k = 0; k < listaCursos.size(); k++) { cursos[k] = listaCursos.get(k); }
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Escolha um curso", "Op��o", JOptionPane.INFORMATION_MESSAGE, null, cursos, cursos[0]);
		return (Curso) valorSelecionado;	
	}


	// CADASTRA ALUNO
	public boolean cadastrarAluno() {
		String nome = JOptionPane.showInputDialog("Nome").trim().replaceAll("( +)", " ");
		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null, NOME_INVALIDO);
			return false;
		}

		String matricula = JOptionPane.showInputDialog("Matr�cula").trim().replaceAll("( +)", "");
		if (matricula.equals("")) {
			JOptionPane.showMessageDialog(null, MATRICULA_INVALIDA);
			return false;
		}

		// verifica se j� existe uma mesma matr�cula cadastrada
		for (Aluno _aluno : database.getListaAlunos()) {
			if (_aluno.getMatricula().equals(matricula)) {
				JOptionPane.showMessageDialog(null, "Matr�cula j� cadastrada no sistema");
				return false;
			}
		}
		String email = JOptionPane.showInputDialog("E-mail").trim().replaceAll("( +)", "");
		if (email.equals("")) {
			JOptionPane.showMessageDialog(null, EMAIL_INVALIDO);
			return false;
		}

		String senha = JOptionPane.showInputDialog("Senha de acesso (n�o use espa�os)");
		String _senha = senha.trim().replaceAll("( +)", "");
		if (!senha.equals(_senha)) {
			JOptionPane.showMessageDialog(null, SENHA_INVALIDA);
			return false;
		}

		Curso curso = this.escolherCurso();
		Aluno aluno = new Aluno(nome, matricula, email, senha, curso);
		database.getListaAlunos().add(aluno);
		curso.adicionarAluno(aluno);
		return true;
	}

	// LISTAR ALUNOS
	public String listarAlunos() {
		String lista = "";
		for (Aluno _aluno : database.getListaAlunos()) {
			lista += _aluno.toString() + "\n\n";
		}
		return lista;
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
		
		
		String listaProfEncontrados = "";
		int cont = 1;
		for (Professor _professor : profEncontrados) {
			listaProfEncontrados += cont++ + ". " + _professor.toString() + "\n";
		}


		while (true) {
			
			Object[] professores = new Object[profEncontrados.size()];
			for (int k = 0; k < profEncontrados.size(); k++) { professores[k] = profEncontrados.get(k); }
			Object selectedValue = JOptionPane.showInputDialog(null, profEncontrados.size() 
					+ " professores encontrados. \nEscolha um:", "Op��o", JOptionPane.INFORMATION_MESSAGE, null, professores, professores[0]);
			return (Professor) selectedValue;
			
		
			}
	}
	

	// TESTA SE EXISTE LOGIN NO BANCO DE DAOS
	public boolean login(String matricula, String senha) {
		for (Aluno _aluno : database.getListaAlunos()) {
			if (_aluno.getMatricula().equals(matricula) && _aluno.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	// ALUNO FAZ AVALIA��O DE UM DETERMINADO PROFESSOR

	// verifica se o aluno j� avaliou o professor em quest�o
	public void avaliarProfessor(Aluno _aluno, Professor prof) {
		while (true) {
			boolean avaliou = this.verificaAvaliou(_aluno.getMatricula(), prof);

			// caso j� tenha avaliado, � printada uma mensagem de aviso e aplicado um break
			// para finalizar o la�o, encerrando tamb�m o m�todo
			if (avaliou) {
				JOptionPane.showMessageDialog(null, "Voc� j� avaliou este professor!");
				break;
			}

			// aqui se segue o c�digo caso o aluno ainda n�o tenha avaliado o professor
			try {
				JOptionPane.showMessageDialog(null, "LEIA COM ATEN��O! \n"
						+ "a. Voc� est� entrando na aba de avalia��o do prof. " + prof.getNome() + "\n"
						+ "b. Informe as notas a seguir de 0 a 10, sendo 0 p�ssimo e 10 �timo \n"
						+ "c. Caso queira sair desta janela, informe uma letra qualquer nas notas exigidas a seguir");

				double notaMetodologiaEnsino = Double.parseDouble(JOptionPane.showInputDialog("Metodologia de ensino"));
				if (!notaValida(notaMetodologiaEnsino)) { throw new NotaInvalida();}
				
				double notaQualMateriais = Double.parseDouble(JOptionPane.showInputDialog("Qualidade dos materiais"));
				if (!notaValida(notaQualMateriais)) { throw new NotaInvalida();}
				
				double notaInteracaoTurma = Double.parseDouble(JOptionPane.showInputDialog("Intera��o com a turma"));
				if (!notaValida(notaInteracaoTurma)) { throw new NotaInvalida();}
				
				double notaFidelidadeMaterial = Double.parseDouble(JOptionPane.showInputDialog("Fiderelidade do prof. com o material"));
				if (!notaValida(notaFidelidadeMaterial)) { throw new NotaInvalida();}
				
				double notaRecomendacao = Double.parseDouble(JOptionPane.showInputDialog("Quanto voc� recomenda o professor"));
				if (!notaValida(notaRecomendacao)) { throw new NotaInvalida();}
				
				String mensagem = null;
				boolean alunoAnonimo = false;
				
				int dxMensagem = JOptionPane.showConfirmDialog(null, "Deseja deixar um coment�rio sobre o professor?", null, JOptionPane.YES_NO_OPTION);
				int anonimo = JOptionPane.showConfirmDialog(null, "Comentar anonimamente?", null, JOptionPane.YES_NO_OPTION);
				
				if (anonimo == 0) {
					alunoAnonimo = true;
				} 
				
				if (dxMensagem == 0) {
					mensagem = JOptionPane.showInputDialog("Seu coment�rio");
					
					try {
						if (mensagem == null) {
							throw new CampoVazio();
						}
					}catch (CampoVazio ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
				} 
				
				Avaliacao _avaliacao = new Avaliacao(notaMetodologiaEnsino, notaQualMateriais, notaInteracaoTurma, notaFidelidadeMaterial, notaRecomendacao, mensagem, _aluno, prof, alunoAnonimo);
				JOptionPane.showMessageDialog(null, "Avalia��o feita com sucesso, obrigado!");
				prof.getAvaliacoesRecebidas().add(_avaliacao);
				break;

				// chamada de erro caso o aluno n�o informe um n�mero nos inputs das notas mais
				// acima
			} catch (NumberFormatException  ex) {
				JOptionPane.showMessageDialog(null,
						"Por favor, informe apenas n�meros");
				break;

			} catch (NotaInvalida ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}

	}

	// M�TODO RETORNA O ALUNO LOGADO NO SISTEMA
	// recebe a m�tricula do aluno do tipo String;
	// testa em cada elemento do tipo Aluno no ArrayList<Aluno> na Database se
	// getMatricula() equivale a String matricula passada no m�todo;
	public Aluno alunoLogado(String matricula) {
		for (Aluno _aluno : database.getListaAlunos()) {
			if (_aluno.getMatricula().equals(matricula)) {
				// caso encontre, retorna o Aluno;
				return _aluno;
			}
		}
		return null;
	}

	// VERIFICA SE AS NOTAS ATRIBU�DAS EST�O ENTRE 0 E 10
	public boolean notaValida(double nota) {
		if (nota < 0 || nota > 10) {
			return false;
		}
		return true;

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

	// VERIFICA SE UM PROFESSOR TEM ALGUMA AVALIA��O
	public boolean profAvaliado(Professor _prof) {
		if (_prof.getAvaliacoesRecebidas().size() == 0) {
			return false;
		}
		return true;
	}

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
			ranking += cont++ + "� | " + profMaiorNota.getNome() + " (" + profMaiorNota.getMatricula() + ") " + "M�dia geral: " + profMaiorNota.calculaMediaGeral() + "\n";
			if (listaProfessoresAvaliados.size() == 1) { return ranking;}
			listaProfessoresAvaliados.remove(profMaiorNota);

			
		}

	}

}
