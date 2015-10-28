package br.com.bicosonline.model;

import javax.persistence.*;


@Entity
public class Classificacao extends EntidadeBase<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2873407762237787522L;
	
	@OneToOne
	private Pessoa pessoa;
	
	private int nota;
	
	public Classificacao() {
		super();
	}
	public Classificacao(Pessoa empregado, int nota) {
		super();
		this.pessoa = empregado;
		this.nota = nota;
	}
	public Pessoa getEmpregado() {
		return pessoa;
	}
	public void setEmpregado(Pessoa empregado) {
		this.pessoa = empregado;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
