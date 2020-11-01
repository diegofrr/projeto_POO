package Class;

public class Avaliacao {
	private double metodologiaEnsino;
	private double qualidadeMateriais;
	private double interacaoTurma;
	private double fidelidadeMaterial;
	private double recomendacao;
	private String mensagem;
	private Aluno aluno;
	private Professor professor;
	
	public Avaliacao(double _met, double _qualidMat, double _intTurma, double _fidMaterial, double _recomendacao, String _mensagem, Aluno _aluno, Professor _prof) {
		this.metodologiaEnsino = _met;
		this.qualidadeMateriais = _qualidMat;
		this.interacaoTurma = _intTurma;
		this.fidelidadeMaterial = _fidMaterial;
		this.recomendacao = _recomendacao;
		this.mensagem = _mensagem;
		this.aluno = _aluno;
		this.professor = _prof;
	}
	
	public Avaliacao() {
		this.metodologiaEnsino = 0;
		this.qualidadeMateriais = 0;
		this.interacaoTurma = 0;
		this.fidelidadeMaterial = 0;
		this.recomendacao = 0;
		this.aluno = new Aluno();
		this.professor = new Professor();
	}
	
	


	public double getQualidadeMateriais() {
		return qualidadeMateriais;
	}


	public void setQualidadeMateriais(double qualidadeMateriais) {
		this.qualidadeMateriais += qualidadeMateriais;
	}



	public double getMetodologiaEnsino() {
		return metodologiaEnsino;
	}



	public void setMetodologiaEnsino(double metodologiaEnsino) {
		this.metodologiaEnsino += metodologiaEnsino;
	}



	public double getInteracaoTurma() {
		return interacaoTurma;
	}



	public void setInteracaoTurma(double interacaoTurma) {
		this.interacaoTurma += interacaoTurma;
	}



	public double getFidelidadeMaterial() {
		return fidelidadeMaterial;
	}



	public void setFidelidadeMaterial(double fidelidadeMaterial) {
		this.fidelidadeMaterial += fidelidadeMaterial;
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
	
	
	
	
	

}
