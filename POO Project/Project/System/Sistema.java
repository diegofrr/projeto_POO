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
			listaProfEncontrados += cont++ +". " + _professor.toString() + "\n\n";
			
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
				break;
				
			}
		}
		return null;
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
	public void avaliarProfessor(Aluno _aluno, Professor prof) {
		while(true) {
		boolean avaliou = this.verificaAvaliou(_aluno.getMatricula(), prof);
		if(avaliou) {
			JOptionPane.showMessageDialog(null, "Voc� j� avaliou este professor!");
			break;
		}
	
		try {
			JOptionPane.showMessageDialog(null, "Aten��o: avalie as perguntas a seguir de 0 a 10, sendo 0 p�ssimo e 10 �timo");
			double notaMetodologiaEnsino = Double.parseDouble(JOptionPane.showInputDialog("Metodologia de ensino"));
			double notaQualMateriais = Double.parseDouble(JOptionPane.showInputDialog("Qualidade dos materiais"));
			double notaInteracaoTurma = Double.parseDouble(JOptionPane.showInputDialog("Intera��o com a turma"));
			double notaFidelidadeMaterial = Double.parseDouble(JOptionPane.showInputDialog("Fiderelidade do prof. com o material"));
			ArrayList<Double> notas = new ArrayList<Double>();
			notas.add(notaMetodologiaEnsino); 
			notas.add(notaQualMateriais); 
			notas.add(notaInteracaoTurma); 
			notas.add(notaFidelidadeMaterial); 
			for(double _nota : notas) {
				if(_nota>10 || _nota<0) {
					//CHAMADA DE ERRO
					notas.add(null);
				}
			}
			double notaRecomendacao = Double.parseDouble(JOptionPane.showInputDialog("Quanto voc� recomenda o professor"));
			String mensagem = JOptionPane.showInputDialog("Deixe um coment�rio");
			Avaliacao _avaliacao = new Avaliacao(notaMetodologiaEnsino, notaQualMateriais, notaInteracaoTurma, notaFidelidadeMaterial, notaRecomendacao,mensagem, _aluno, prof);
			JOptionPane.showMessageDialog(null, "Avalia��o feita com sucesso, obrigado!");
			prof.getAvaliacao().add(_avaliacao);
			break;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Algo saiu errado! Verifique sua notas aplicadas e tente novamente \n");
			break;
			
		}
		}
		
		
	}
	
	//VOLTA UM TIPO ALUNO (ALUNO LOGADO NO SISTEMA)
	public Aluno alunoLogado(String matricula) {
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula)) {
				return _aluno;
			}
		}
		return null;
	}
	
	//VERIFICA SE A NOTA ATRIBUIDA � MAIOR QUE 0 E MENOS QUE 10
	//VERIFICA SE A NOTA ATRIBU�DA EST� ENTRE 0 E 10
	public boolean testarNota(double nota) {
		if(nota <= 10) {
			return true;
		}
		return false;
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
