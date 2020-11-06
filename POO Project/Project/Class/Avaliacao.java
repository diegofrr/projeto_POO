package Class;

public class Avaliacao {
	private double metodologiaEnsino;
	private double qualidadeMateriais;
	private double interacaoTurma;
	private double fidelidadeCronograma;
	private double recomendacao;
	private String mensagem;
	private Aluno aluno;
	private Professor professor;
	private boolean anonimo;
	
	public Avaliacao(double _met, double _qualidMat, double _intTurma, double _fidCronograma, double _recomendacao, String _mensagem, Aluno _aluno, Professor _prof, boolean _anonimo) {
		this.metodologiaEnsino = _met;
		this.qualidadeMateriais = _qualidMat;
		this.interacaoTurma = _intTurma;
		this.fidelidadeCronograma = _fidCronograma;
		this.recomendacao = _recomendacao;
		this.mensagem = _mensagem;
		this.aluno = _aluno;
		this.professor = _prof;
		this.anonimo = _anonimo;
	}
	
	public Avaliacao() {
		this.metodologiaEnsino = 0;
		this.qualidadeMateriais = 0;
		this.interacaoTurma = 0;
		this.fidelidadeCronograma = 0;
		this.recomendacao = 0;
		this.mensagem = "";
		this.aluno = new Aluno();
		this.professor = new Professor();
		this.anonimo = false;
	}
	
	


	public double getQualidadeMateriais() {
		return qualidadeMateriais;
	}


	public void setQualidadeMateriais(double qualidadeMateriais) {
		this.qualidadeMateriais = qualidadeMateriais;
	}



	public double getMetodologiaEnsino() {
		return metodologiaEnsino;
	}



	public void setMetodologiaEnsino(double metodologiaEnsino) {
		this.metodologiaEnsino = metodologiaEnsino;
	}



	public double getInteracaoTurma() {
		return interacaoTurma;
	}



	public void setInteracaoTurma(double interacaoTurma) {
		this.interacaoTurma = interacaoTurma;
	}



	public double getFidelidadeCronograma() {
		return fidelidadeCronograma;
	}



	public void setFidelidadeCronograma(double fidCronograma) {
		this.fidelidadeCronograma = fidCronograma;
	}



	public double getRecomendacao() {
		return recomendacao;
	}



	public void setRecomendacao(double recomendacao) {
		this.recomendacao = recomendacao;
	}



	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public Professor getProfessor() {
		return professor;
	}



	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}
	
}
