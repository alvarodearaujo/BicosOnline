package br.com.bicosonline.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Pessoa extends EntidadeBase<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5973360350354231876L;
	
	private String nome, cpf, rg, orgaoExpedidor, email, telefone, celular;
	
	private LocalDate dataNascimento;
	
	private boolean isEmpregado, isEmpregador, isIntermediario;
	
	private Sexo sexo;
	
	@Transient
	private Endereco endereco;
	
	@OneToMany(mappedBy="pessoa")
	private List<Anuncio> anuncio;
	
	@ManyToOne
	private Pessoa intermediario;
	
	@OneToOne
	private User usuario;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, String rg, String orgaoExpedidor, String email, String telefone,
			String celular, LocalDate dataNascimento, boolean isEmpregado, boolean isEmpregador,
			boolean isIntermediario, Sexo sexo, Endereco endereco, Pessoa pessoa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.orgaoExpedidor = orgaoExpedidor;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.dataNascimento = dataNascimento;
		this.isEmpregado = isEmpregado;
		this.isEmpregador = isEmpregador;
		this.isIntermediario = isIntermediario;
		this.sexo = sexo;
		this.endereco = endereco;
		this.intermediario = pessoa;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}
	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean isEmpregado() {
		return isEmpregado;
	}
	public void setEmpregado(boolean isEmpregado) {
		this.isEmpregado = isEmpregado;
	}
	public boolean isEmpregador() {
		return isEmpregador;
	}
	public void setEmpregador(boolean isEmpregador) {
		this.isEmpregador = isEmpregador;
	}
	public boolean isIntermediario() {
		return isIntermediario;
	}
	public void setIntermediario(boolean isIntermediario) {
		this.isIntermediario = isIntermediario;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Pessoa pessoa) {
		this.intermediario = pessoa;
	}

	public List<Anuncio> getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(List<Anuncio> anuncio) {
		this.anuncio = anuncio;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

}
