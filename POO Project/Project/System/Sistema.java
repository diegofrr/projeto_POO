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
				JOptionPane.showMessageDialog(null, "Por favor, digite uma opção válida!");
				
			}
		}	
		}

	
//CADASTRA ALUNO
	public boolean cadastrarAluno() {
		String nome = JOptionPane.showInputDialog("Nome");
		String matricula = JOptionPane.showInputDialog("Matrícula");
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula)) {
				JOptionPane.showMessageDialog(null, "Matrícula já cadastrada no sistema");
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
				JOptionPane.showMessageDialog(null, "Por favor, digite uma opção válida!");
				
			}
		}
	}


	//PROCURAR PROFESSOR PELA MATRICULA
	public Professor procurarProfessorPelaMatricula(String matricula) {
		ArrayList<Professor> professores = database.getListaProfessores();
		String lista = "";
		for(Professor _prof : professores) {
			if(_prof.getMatricula().equals(matricula)) {
				return _prof;
			}
		}return null;
	}
	
	public String listarProfessores() {
		ArrayList<Professor> professores = database.getListaProfessores();
		String lista = "";
		for(Professor _prof : professores) {
			lista += _prof.toString() + "\n\n";
		}
		return lista;
	}
	
	public boolean login(String matricula, String senha) {
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula) && _aluno.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	public void avaliarProfessor(Aluno _aluno, Professor prof) {
		
		
		try {
			
			JOptionPane.showMessageDialog(null, "Atenção: avalie as perguntas a seguir de 0 a 10, sendo 0 péssimo e 10 ótimo");
			double notaMetodologiaEnsino = Double.parseDouble(JOptionPane.showInputDialog("Metodologia de ensino"));
			double notaQualMateriais = Double.parseDouble(JOptionPane.showInputDialog("Qualidade dos materiais"));
			double notaInteracaoTurma = Double.parseDouble(JOptionPane.showInputDialog("Interação com a turma"));
			double notaFidelidadeMaterial = Double.parseDouble(JOptionPane.showInputDialog("Fiderelidade do prof. com o material"));
			double notaRecomendacao = Double.parseDouble(JOptionPane.showInputDialog("Quanto você recomenda o professor"));
			Avaliacao _avaliacao = new Avaliacao(notaMetodologiaEnsino, notaQualMateriais, notaInteracaoTurma, notaFidelidadeMaterial, notaRecomendacao,_aluno, prof);
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Por favor, digite uma opção válida!");
			
		}
		
		
	}
	
	public Aluno alunoLogado(String matricula) {
		for(Aluno _aluno : database.getListaAlunos()) {
			if(_aluno.getMatricula().equals(matricula)) {
				return _aluno;
			}
		}
		return null;
	}
	

}
