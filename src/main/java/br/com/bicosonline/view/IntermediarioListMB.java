package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.support.Fachada;

@Named(value="intermediarioListMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class IntermediarioListMB {

	@Autowired
	private Fachada fachada;
	
	@Autowired
	private IntermediarioAdmEditMB intermediarioEditMB;
	
	private List<Pessoa> listaIntermediarios;
	
	@PostConstruct
	public void init(){
		this.listaIntermediarios= this.fachada.listarIntermediarios();
	}
	
	public void editar(Pessoa p){
		this.intermediarioEditMB.editar(p);
	}

	public void excluir(Pessoa p){
		Endereco e = fachada.procurarEndereco(p);
		this.fachada.removerPessoa(p,e);
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}


	public IntermediarioAdmEditMB getIntermediarioEditMB() {
		return intermediarioEditMB;
	}

	public void setIntermediarioEditMB(IntermediarioAdmEditMB intermediarioEditMB) {
		this.intermediarioEditMB = intermediarioEditMB;
	}

	public List<Pessoa> getListaIntermediarios() {
		return listaIntermediarios;
	}

	public void setListaIntermediarios(List<Pessoa> listaIntermediarios) {
		this.listaIntermediarios = listaIntermediarios;
	}
	
}
