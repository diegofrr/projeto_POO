package Database;

import Class.Aluno;
import Class.Curso;
import Class.Professor;
import Interfaces.InterfaceDatabase;

import java.util.ArrayList;
import java.util.Arrays;

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
			
			 
			 /*CRIANDO PROFESSORES:
			  * Primeiro seleciona o(s) curso(s) do professor;
			  * Atribui ao objeto _professor nome, matrícula, e-mail e a lista de cursos.
			  */
			 
			 
			 ArrayList<Curso> cursos;
			 
			 //PROFESSOR 1:
			cursos = new ArrayList<Curso>(Arrays.asList(cursoSI, cursoCC));
			Professor professor1 = new Professor("PROFESSOR1", "1111111", "PROFESSOR1@GMAIL.COM", cursos);	
			for (Curso c : cursos) { c.adicionarProfessor(professor1);}
			listaProfessores.add(professor1);
			
			
			//PROFESSOR 2:
			cursos = new ArrayList<Curso>(Arrays.asList(cursoDesign));
			Professor professor2 = new Professor("PROFESSOR2", "2222222", "PROFESSOR2@GMAIL.COM", cursos);
			for (Curso c : cursos) { c.adicionarProfessor(professor2);; }
			listaProfessores.add(professor2);
			
			
			//PROFESSOR 3:
			cursos = new ArrayList<Curso>(Arrays.asList(cursoAntropologia));
			Professor professor3 = new Professor("PROFESSOR3", "3333333", "PROFESSOR3@GMAIL.COM", cursos);
			for (Curso c : cursos) { c.adicionarProfessor(professor3); }
			listaProfessores.add(professor3);
			
			
			//PROFESSOR 4:
			cursos = new ArrayList<Curso>(Arrays.asList(cursoAntropologia, cursoMatematica));
			Professor _professor4 = new Professor("PROFESSOR4", "4444444", "PROFESSOR4@GMAIL.COM", cursos);
			for (Curso c : cursos) { c.adicionarProfessor(_professor4); }
			listaProfessores.add(_professor4);
			
			
			//PROFESSOR 5:
			cursos = new ArrayList<Curso>(Arrays.asList(cursoLetras, cursoEcologia));
			Professor _professor5 = new Professor("PROFESSOR5", "5555555", "PROFESSOR5@GMAIL.COM", cursos);
			for (Curso c : cursos) { c.adicionarProfessor(_professor5); }
			listaProfessores.add(_professor5);
	
			
			
			///////////CADASTRAR ALUNO PARA TESTAR O SISTEMA
			Aluno _aluno = new Aluno("Diêgo Raian da Silva Ferreira", "000", "Diego@gmail.com", "admin123",cursoSI);
			this.listaAlunos.add(_aluno);
			cursoSI.adicionarAluno(_aluno);

			
		}
	
		public ArrayList<Professor> getListaProfessores() {
			return listaProfessores;
		}



		public void setListaProfessores(ArrayList<Professor> listaProfessores) {
			this.listaProfessores = listaProfessores;
		}



		public ArrayList<Aluno> getListaAlunos() {
			return this.listaAlunos;
		}


		public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
			this.listaAlunos = listaAlunos;
		}
		
		public ArrayList<Curso> getListaCursos() {
			return this.listaCursos;
		}


		public void setListaCursos(ArrayList<Curso> listaCursos) {
			this.listaCursos = listaCursos;
		}
		
		public String listarCursos() {
			String lista = "";
			for(Curso _curso : listaCursos) {
				lista += _curso.toStringCodigo();
			}return lista;
		}
		
		public String listarAlunosDeCurso(Curso _curso) {
			if (_curso.getListaAlunos().size() == 0) return "Nenhum aluno cadastrado neste curso";
			
			String lista = "";
			for(Aluno _aluno : _curso.getListaAlunos()) {
				lista += 	"Nome: " + _aluno.getNome() + "\n"
						+	"Matrícula: " +_aluno.getMatricula();
			}
			return lista;
		}
		
		public String listarProfessoresDeCurso(Curso _curso) {
			if (_curso.getListaProfessores().size() == 0) return "Nenhum professor cadastrado neste curso";
			String lista = "";
			for(Professor _prof : _curso.getListaProfessores()) {
				lista += _prof.toStringAll() ;
			}
			return lista;
		}
		
		public String listarProfessores() {
			String lista = "";
			for(Professor _prof : getListaProfessores()) {
				lista += _prof.toStringAll() ;
			}
			return lista;
		}

}
