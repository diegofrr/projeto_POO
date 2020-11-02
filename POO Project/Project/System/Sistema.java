package System;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import Class.Aluno;
import Class.Avaliacao;
import Class.Curso;
import Class.Professor;
import Database.Database;
import Interface.Interface;

public class Sistema implements Interface {
	Database database = new Database();

	//ESCOLHE UM CURSO DISPON�VEL
	public Curso escolherCurso() {
		String listaCursosStr = "";
		int cont = 1;
		ArrayList<Curso> listaCursos = database.getListaCursos();
		
		for (Curso _curso : listaCursos) {
			listaCursosStr += cont++ + ". " + _curso.getNome() + "\n";
		}
		while(true) {
			try {
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha um curso:" + "\n" + listaCursosStr));
				return listaCursos.get(opcao-1);
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Por favor, digite uma op��o v�lida!");
				
			}
		}	
		}

	
	//CADASTRA ALUNO
	public boolean cadastrarAluno() {
		String nome = JOptionPane.showInputDialog("Nome");
		String matricula = JOptionPane.showInputDialog("Matr�cula");
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula)) {
				JOptionPane.showMessageDialog(null, "Matr�cula j� cadastrada no sistema");
				return false;
			}
		}
		String email = JOptionPane.showInputDialog("E-mail");
		String senha = JOptionPane.showInputDialog("Senha de acesso");
		Curso curso = this.escolherCurso();
		Aluno aluno = new Aluno(nome, matricula, email, senha, curso);
		database.getListaAlunos().add(aluno);;
		return true;
	}
	
	
	//LISTAR ALUNOS
	public String listarAlunos() {
		String lista = "";
		for(Aluno _aluno : database.getListaAlunos()) {
			lista += _aluno.toString() + "\n\n";
		}
		return lista;
	}
	
	
	//PROCURA UM PROFESSOR PELO NOME
	public Professor procurarProfessorPeloNome(String nome) {
		ArrayList<Professor> profEncontrados = new ArrayList<Professor>();
		for(Professor _prof : database.getListaProfessores()) {
			if(_prof.getNome().toUpperCase().contains(nome.toUpperCase())) {
				profEncontrados.add(_prof);
			}
		}
		String listaProfEncontrados = "";
		int cont = 1;
		for(Professor _professor : profEncontrados) {
			listaProfEncontrados += cont++ +". " + _professor.toString() + "\n";
		}
		if(profEncontrados.size() == 0) {
			return null;
		}
		
		else if(profEncontrados.size() == 1) {
			JOptionPane.showMessageDialog(null, "1 professor encontrado \n\n" + listaProfEncontrados);
			return profEncontrados.get(0);
		}
		
		while(true) {
			try {
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(profEncontrados.size() + " professor(es) encontrad(os), escolha um:" + "\n\n" + listaProfEncontrados));
				return profEncontrados.get(opcao-1);
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Por favor, digite uma op��o v�lida!");
				
			}
		}
	}

	
	//LISTAR OS PROFESSORES
	public String listarProfessores() {
		ArrayList<Professor> professores = database.getListaProfessores();
		String lista = "";
		for(Professor _prof : professores) {
			lista += _prof.toString() + "\n\n";
		}
		return lista;
	}
	
	
	//TESTA SE EXISTE LOGIN NO BANCO DE DAOS
	public boolean login(String matricula, String senha) {
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula) && _aluno.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	
	//ALUNO FAZ AVALIA��O DE UM DETERMINADO PROFESSOR
	 
	// verifica se o aluno j� avaliou o professor em quest�o
	public void avaliarProfessor(Aluno _aluno, Professor prof) {
		while(true) {
		boolean avaliou = this.verificaAvaliou(_aluno.getMatricula(), prof);
		
		// caso j� tenha avaliado, � printada uma mensagem de aviso e aplicado um break para finalizar o la�o, encerrando tamb�m o m�todo
		if(avaliou) {
			JOptionPane.showMessageDialog(null, "Voc� j� avaliou este professor!");
			break;
		}
		
		// aqui se segue o c�digo caso o aluno ainda n�o tenha avaliado o professor
		try {
			JOptionPane.showMessageDialog(null, "LEIA COM ATEN��O! \n" + 
					"a. Voc� est� entrando na aba de avalia��o do prof. " + prof.getNome() + "\n" +
					"b. Informe as notas a seguir de 0 a 10, sendo 0 p�ssimo e 10 �timo \n" + 
					"c. Caso queira sair desta janela, informe uma letra qualquer nas notas exigidas a seguir");

			double notaMetodologiaEnsino = Double.parseDouble(JOptionPane.showInputDialog("Metodologia de ensino (0 - 10)"));
			double notaQualMateriais = Double.parseDouble(JOptionPane.showInputDialog("Qualidade dos materiais (0 - 10)"));
			double notaInteracaoTurma = Double.parseDouble(JOptionPane.showInputDialog("Intera��o com a turma (0 - 10)"));
			double notaFidelidadeMaterial = Double.parseDouble(JOptionPane.showInputDialog("Fiderelidade do prof. com o material (0 - 10)"));
			double notaRecomendacao = Double.parseDouble(JOptionPane.showInputDialog("Quanto voc� recomenda o professor (0 - 10)"));
			boolean notaAceita = this.testarNota(notaMetodologiaEnsino, notaQualMateriais, notaInteracaoTurma, notaFidelidadeMaterial, notaRecomendacao);

			// for utilizado para testar se todas as notas recebidas est�o entre 0 e 10
			if(!notaAceita) {
				throw new Exception();
			}
	
			String mensagem = JOptionPane.showInputDialog("Deixe um coment�rio");
			Avaliacao _avaliacao = new Avaliacao(notaMetodologiaEnsino, notaQualMateriais, notaInteracaoTurma, notaFidelidadeMaterial, notaRecomendacao,mensagem, _aluno, prof);
			JOptionPane.showMessageDialog(null, "Avalia��o feita com sucesso, obrigado!");
			prof.getAvaliacao().add(_avaliacao);
			break;
			
			// chamada de erro caso o aluno n�o informe um n�mero nos inputs das notas mais acima
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Algo saiu errado! Verifique sua notas aplicadas e tente novamente \n");
			break;
			
		}
		}
		
		
	}
	
	// M�TODO RETORNA O ALUNO LOGADO NO SISTEMA
	// recebe a m�tricula do aluno do tipo String;
	// testa em cada elemento do tipo Aluno no ArrayList<Aluno> na Database se getMatricula() equivale a String matricula passada no m�todo;
	public Aluno alunoLogado(String matricula) {
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula)) {
				// caso encontre, retorna o Aluno;
				return _aluno;
			}
		}
		return null;
	}
	
	
	
	//VERIFICA SE AS NOTAS ATRIBU�DAS EST�O ENTRE 0 E 10
	public boolean testarNota(double nota1, double nota2, double nota3, double nota4, double nota5) {
		ArrayList<Double> notas = new ArrayList<Double>();
		notas.add(nota1);	notas.add(nota2);	notas.add(nota3);	notas.add(nota4); notas.add(nota5);
		
		for(double _nota : notas) {
			if(_nota < 0 || _nota > 10) {
				return false;
			}
		}
		return true;
		
	}
	
	
	//VERIFICA SE ALUNO JA AVALIOU UM PROFESSOR
	public boolean verificaAvaliou(String matricula, Professor prof) {
		for(Avaliacao _avaliacao : prof.getAvaliacao()) {
			if(_avaliacao.getAluno().getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;
	}
	

	public boolean profAvaliado(Professor _prof) {
		if(_prof.getAvaliacao().size() == 0) {
			return false;
		}
		return true;
	}
	

}
