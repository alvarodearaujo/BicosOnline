package br.com.bicosonline.model;

import javax.persistence.*;

@Entity
public class Anuncio extends EntidadeBase<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7082239782574714323L;

	@ManyToOne
	private Pessoa pessoa;
	
	@Transient
	private Pessoa empregador;
	
	private Long idEmpregado, idIntermediario;
	
	private boolean IsAberto;
	
	private String titulo, descricao, requesitos, valor;
	
	@Enumerated
	private AreaTrabalho area;
	
	public Anuncio() {}
	
	public Anuncio(Pessoa pessoa, Long idEmpregado, Long idIntermediario, boolean isAberto, String titulo,
			String descricao, String requesitos, String valor, AreaTrabalho area) {
		super();
		this.pessoa = pessoa;
		this.idEmpregado = idEmpregado;
		this.idIntermediario = idIntermediario;
		IsAberto = isAberto;
		this.titulo = titulo;
		this.descricao = descricao;
		this.requesitos = requesitos;
		this.valor = valor;
		this.area = area;
	}

	public Pessoa getAnunciante() {
		return pessoa;
	}
	public void setAnunciante(Pessoa anunciante) {
		this.pessoa = anunciante;
	}
	public void setIsAberto(boolean isAberto) {
		IsAberto = isAberto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getRequesitos() {
		return requesitos;
	}
	public void setRequesitos(String requesitos) {
		this.requesitos = requesitos;
	}
	public AreaTrabalho getArea() {
		return area;
	}
	public void setArea(AreaTrabalho area) {
		this.area = area;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Long getIdEmpregado() {
		return idEmpregado;
	}
	public void setIdEmpregado(Long idEmpregado) {
		this.idEmpregado = idEmpregado;
	}
	public Long getIdIntermediario() {
		return idIntermediario;
	}
	public void setIdIntermediario(Long idIntermediario) {
		this.idIntermediario = idIntermediario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean isIsAberto() {
		return IsAberto;
	}
}
