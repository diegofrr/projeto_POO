package Database;

import Class.Aluno;
import Class.Avaliacao;
import Class.Curso;
import Class.Pessoa;
import Class.Professor;
import Interfaces.InterfaceDatabase;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database implements InterfaceDatabase {
	private ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();	
	private ArrayList<Curso> listaCursos = new ArrayList<Curso>();

		public Database() {
			
			//CURSOS DISPONÍVEIS NO CAMPUS IV - RIO TINTO
			Curso cursoSI 				= 	new Curso("SISTEMAS DE INFORMAÇÃO"	, 	"1111111"); listaCursos.add(cursoSI);
			Curso cursoCC 				= 	new Curso("CIÊNCIA DA COMPUTAÇÃO" 	, 	"2222222"); listaCursos.add(cursoCC);
			Curso cursoLetras 			= 	new Curso("LETRAS" 					, 	"3333333"); listaCursos.add(cursoLetras);
			Curso cursoDesign 			= 	new Curso("DESIGN" 					, 	"4444444"); listaCursos.add(cursoDesign);
			Curso cursoEcologia 		= 	new Curso("ECOLOGIA" 				, 	"5555555"); listaCursos.add(cursoEcologia);
			Curso cursoMatematica 		=	new Curso("MATEMÁTICA" 				, 	"6666666"); listaCursos.add(cursoMatematica);
			Curso cursoAntropologia 	= 	new Curso("ANTROPOLOGIA" 			, 	"7777777"); listaCursos.add(cursoAntropologia);
			
			 ArrayList<Curso> _cursos = new ArrayList<Curso>();	
			 
			 /*CRIANDO PROFESSORES:
			  * Primeiro seleciona o(s) curso(s) do professor;
			  * Atribui ao objeto _professor nome, matrícula, e-mail e a lista de cursos.
			  */
			 
			 //PROFESSOR 1:
			Professor _professor1 = new Professor("PROFESSOR1", "1111111", "PROFESSOR1@GMAIL.COM");
			_professor1.getListaCursos().add(cursoSI);
			_professor1.getListaCursos().add(cursoCC);
			cursoSI.adicionarProfessor(_professor1);
			cursoCC.adicionarProfessor(_professor1);
			listaProfessores.add(_professor1);
			
			//PROFESSOR 2:
			Professor _professor2 = new Professor("PROFESSOR2", "2222222", "PROFESSOR2@GMAIL.COM");
			_professor2.getListaCursos().add(cursoDesign);
			cursoDesign.adicionarProfessor(_professor2);
			listaProfessores.add(_professor2);
			
			
			//PROFESSOR 3:
			Professor _professor3 = new Professor("PROFESSOR3", "3333333", "PROFESSOR3@GMAIL.COM");
			_professor3.getListaCursos().add(cursoDesign);
			cursoDesign.adicionarProfessor(_professor3);
			listaProfessores.add(_professor3);
			
			//PROFESSOR 4:
			Professor _professor4 = new Professor("PROFESSOR4", "4444444", "PROFESSOR4@GMAIL.COM");
			_professor4.getListaCursos().add(cursoAntropologia);
			_professor4.getListaCursos().add(cursoMatematica);
			cursoAntropologia.adicionarProfessor(_professor4);
			cursoMatematica.adicionarProfessor(_professor4);
			listaProfessores.add(_professor4);
			
			//PROFESSOR 5:
			Professor _professor5 = new Professor("PROFESSOR5", "5555555", "PROFESSOR5@GMAIL.COM");
			_professor4.getListaCursos().add(cursoMatematica);
			cursoMatematica.adicionarProfessor(_professor5);
			listaProfessores.add(_professor4);
			
			
			
			
			///////////TESTE
			Aluno _aluno = new Aluno("Administrador", "000", "Admin@gmail.com", "admin123");
			_aluno.setCurso(cursoSI);
			cursoSI.adicionarAluno(_aluno);
			listaAlunos.add(_aluno);
			
		}
	
		public ArrayList<Professor> getListaProfessores() {
			return listaProfessores;
		}



		public void setListaProfessores(ArrayList<Professor> listaProfessores) {
			this.listaProfessores = listaProfessores;
		}



		public ArrayList<Aluno> getListaAlunos() {
			return listaAlunos;
		}



		public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
			this.listaAlunos = listaAlunos;
		}
		
		public ArrayList<Curso> getListaCursos() {
			return listaCursos;
		}



		public void setListaCursos(ArrayList<Curso> listaCursos) {
			this.listaCursos = listaCursos;
		}
		
		public String listarCursos() {
			String lista = "";
			for(Curso _curso : listaCursos) {
				lista += _curso.toString();
			}return lista;
		}
		
		public String listarAlunosDeCurso(Curso _curso) {
			if (_curso.getListaAlunos().size() == 0) return "Nenhum aluno cadastrado neste curso";
			
			String lista = "";
			for(Aluno _aluno : _curso.getListaAlunos()) {
				lista += _aluno.toString() + "\n";
			}
			return lista;
		}
		
		public String listarProfessoresDeCurso(Curso _curso) {
			if (_curso.getListaProfessores().size() == 0) return "Nenhum professor cadastrado neste curso";
			String lista = "";
			for(Professor _prof : _curso.getListaProfessores()) {
				lista += _prof.toString() + "\n";
			}
			return lista;
		}
		
		public String listarProfessores() {
			String lista = "";
			for(Professor _prof : getListaProfessores()) {
				lista += _prof.toString() + "\n";
			}
			return lista;
		}

}
