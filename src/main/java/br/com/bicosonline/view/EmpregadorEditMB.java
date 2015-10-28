package br.com.bicosonline.view;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Estados;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.support.Fachada;

@Named(value = "empregadorEditMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmpregadorEditMB {

	@Autowired
	private Fachada fachada;

	private Pessoa pessoa;

	private List<Estados> listaEstado;

	private List<Sexo> listaSexo;

	private Endereco endereco;

	private Date dataNascimento;

	private LocalDate data;

	@PostConstruct
	public void init() {
		this.pessoa = new Pessoa();
		this.endereco = new Endereco();
	}

	public String salvar() {
		this.pessoa.setEmpregador(true);
		this.pessoa.setEndereco(endereco);

		this.setData(dataNascimento);
		this.pessoa.setDataNascimento(data);

		this.pessoa.setDataNascimento(data);
		this.fachada.salvarPessoa(this.pessoa);
		return "success";
	}

	public void editar(Pessoa p) {
		this.pessoa = p;
		this.setEndereco(pessoa.getEndereco());
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Estados> getListaEstado() {
		return Arrays.asList(Estados.values());
	}

	public void setListaEstado(List<Estados> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Sexo> getListaSexo() {
		return Arrays.asList(Sexo.values());
	}

	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setData(Date date) {
		Instant instant = date.toInstant();
		this.data = instant.atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
