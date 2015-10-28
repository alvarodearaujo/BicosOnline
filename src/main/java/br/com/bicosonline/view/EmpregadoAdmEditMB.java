package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Classificacao;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.support.Fachada;
@Named(value="empregadoAdmEditMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class EmpregadoAdmEditMB {

	@Autowired
	private Fachada fachada;
	
	private Pessoa pessoa;
	
	private List<Sexo> listaSexo;
	
	private Classificacao classificacao;
	
	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
	}
	
	public String salvar(){
		this.fachada.classificar(classificacao);
		return "success";
	}
	
	public void editar(Pessoa p){
		this.pessoa = p;
		this.classificacao.setEmpregado(p);
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


	public List<Sexo> getListaSexo() {
		return listaSexo;
	}

	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}


	
}
