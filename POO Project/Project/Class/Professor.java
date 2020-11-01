package Class;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Professor extends Pessoa{
	private ArrayList<Curso>  listaCursos = new ArrayList<Curso>();
	private ArrayList<Avaliacao> avaliacao;
	
	public Professor(String _nome, String _matricula, String _email, ArrayList<Curso> _cursos, ArrayList<Avaliacao> _avaliacao) {
		super(_nome, _matricula, _email);
		for(Curso _curso : _cursos) {
			listaCursos.add(_curso);
		}
		this.avaliacao = _avaliacao;
		
	}
	
	public Professor() {
		super();
		this.listaCursos = new ArrayList<Curso>();
		this.avaliacao = new ArrayList<Avaliacao>();
	
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
		}
		
	
		return lista;
		
	}
	
	public String toString() {
		return "Nome: " + getNome() + "\n"
				+ "Matrícula: " + getMatricula() + "\n"
				+ "E-mail: " + getEmail() + "\n"
				+ "Curso(s): \n" + listarCursos() ;
	}

	public ArrayList<Avaliacao> getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public double calculaMetodologiaEnsino() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacao();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getMetodologiaEnsino();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}

	public double calculaQualidadeMateriais() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacao();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getQualidadeMateriais();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}
	
	public double calculaInteracaoTurma() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacao();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getInteracaoTurma();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}


	public double calculaFidelidadeCronograma() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacao();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getFidelidadeCronograma();
		}
		return avaliacaoGeral / quantAvaliacoes;
		
	}
	
	public double calculaRecomendacao() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacao();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getRecomendacao();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}
	
	public double calculaMediaGeral() {
		return 		(	this.calculaMetodologiaEnsino()
				+ 		this.calculaQualidadeMateriais()
				+ 		this.calculaInteracaoTurma()
				+		this.calculaFidelidadeCronograma() 
				+ 		this.calculaRecomendacao()) / 5;
	}
	
	
	public String notas() {
		return	"Médias \n" +
				"Metodologia de ensino: " 		+ this.calculaMetodologiaEnsino() 		+ 	"\n" +
				"Qualidade dos materis: " 		+ this.calculaQualidadeMateriais() 		+	"\n" +
				"Interação com a turma: " 		+ this.calculaInteracaoTurma() 			+	"\n" +
				"Fidelidade com o cronograma: " + this.calculaFidelidadeCronograma() 	+	"\n" +
				"Recomendação do prof.: "			+ this.calculaRecomendacao() 			+	"\n" +
				"Médica geral: "				+ this.calculaMediaGeral();				
	}
	
	public String comentarios() {
		String lista = "";
		for(Avaliacao _avaliacao : getAvaliacao()) {
			lista += "Autor: " + _avaliacao.getAluno().getNome() + " (" + _avaliacao.getAluno().getMatricula() + ")\n"
					+ "- " + _avaliacao.getMensagem() + "\n\n";
		}
		return lista;
	}

}
