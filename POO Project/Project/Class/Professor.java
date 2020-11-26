package Class;

import java.util.ArrayList;


public class Professor extends Pessoa{
	private ArrayList<Curso>  listaCursos = new ArrayList<Curso>();
	private ArrayList<Avaliacao> avaliacoesRecebidas = new ArrayList<Avaliacao>();
	
	public Professor(String _nome, String _matricula, String _email, ArrayList<Curso> _cursos) {
		super(_nome, _matricula, _email);
		this.listaCursos = _cursos;
		
	}
	
	public Professor() {
		super();
		this.listaCursos = new ArrayList<Curso>();
	}

	public void adicionarAvaliacao(Avaliacao av) {
		this.avaliacoesRecebidas.add(av);
	}
	
	public ArrayList<Curso> getListaCursos() {
		return listaCursos;
	}
	
	public String listarCursos() {
		String lista = "";
		for(Curso _curso : listaCursos) {
			lista += _curso.toStringCodigo();
		}
		
	
		return lista;
		
	}
	
	public String toStringAll() {
		return "Nome: " + getNome() + "\n"
				+ "Matrícula: " + getMatricula() + "\n"
				+ "E-mail: " + getEmail() + "\n"
				+ "Curso(s): \n" + listarCursos() + "\n";
	}
	public String toString() {
		return getNome();
	}

	public ArrayList<Avaliacao> getAvaliacoesRecebidas() {
		return this.avaliacoesRecebidas;
	}

	public void setAvaliacoesRecebidas(ArrayList<Avaliacao> avaliacao) {
		this.avaliacoesRecebidas = avaliacao;
	}
	
	public double calculaMetodologiaEnsino() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacoesRecebidas();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getMetodologiaEnsino();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}

	public double calculaQualidadeMateriais() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacoesRecebidas();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getQualidadeMateriais();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}
	
	public double calculaInteracaoTurma() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacoesRecebidas();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getInteracaoTurma();
		}
		return avaliacaoGeral / quantAvaliacoes;
	}


	public double calculaFidelidadeCronograma() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacoesRecebidas();
		int quantAvaliacoes = _avaliacao.size();
		double avaliacaoGeral = 0;
		for(Avaliacao av : _avaliacao) {
			avaliacaoGeral += av.getFidelidadeCronograma();
		}
		return avaliacaoGeral / quantAvaliacoes;
		
	}
	
	public double calculaRecomendacao() {
		ArrayList<Avaliacao> _avaliacao = this.getAvaliacoesRecebidas();
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
				"Recomendação do prof.: "		+ this.calculaRecomendacao() 			+	"\n" +
				"Média geral: "					+ this.calculaMediaGeral();				
	}
	
	public String comentarios() {
		String lista = "";
		for(Avaliacao _avaliacao : getAvaliacoesRecebidas()) {
			if(_avaliacao.getMensagem() == null) {
				
			}else {
				String nomeAluno = _avaliacao.getAluno().getNome();
				String matAluno = " (" + _avaliacao.getAluno().getMatricula() + ")";
				if (_avaliacao.isAnonimo()) { nomeAluno = "Anônimo"; matAluno = "";}
				
				lista += "Autor: " + nomeAluno + matAluno + "\n"
						+ "- " + _avaliacao.getMensagem() + "\n\n";
			}
		}
		
		if (lista == "") {
			String nomeProf = getAvaliacoesRecebidas().get(0).getProfessor().getNome();
			return nomeProf + " não recebeu nenhum comentário";
		}
		
		return lista;
	}

}
