package Database;

import Class.Aluno;
import Class.Avaliacao;
import Class.Curso;
import Class.Professor;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database {
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
			 _cursos.add(cursoSI);
			 _cursos.add(cursoCC);
			Professor _professor1 = new Professor("PROFESSOR1", "1111111", "PROFESSOR1@GMAIL.COM", _cursos, new ArrayList<Avaliacao>());
			listaProfessores.add(_professor1);
			_cursos.clear();
			
			
			//PROFESSOR 2:
			_cursos.add(cursoDesign);
			Avaliacao _avaliacao2 = new Avaliacao();
			Professor _professor2 = new Professor("PROFESSOR2", "2222222", "PROFESSOR2@GMAIL.COM", _cursos, new ArrayList<Avaliacao>());
			listaProfessores.add(_professor2);
			_cursos.clear();
			
			
			//PROFESSOR 3:
			_cursos.add(cursoDesign);
			Professor _professor3 = new Professor("PROFESSOR3", "3333333", "PROFESSOR3@GMAIL.COM", _cursos, new ArrayList<Avaliacao>());
			listaProfessores.add(_professor3);
			_cursos.clear();
			
			
			///////////TESTE
			Aluno _aluno = new Aluno("Administrador", "000", "Admin@gmail.com", "admin123", cursoSI);
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

}
