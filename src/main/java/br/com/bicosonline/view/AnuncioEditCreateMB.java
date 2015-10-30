package br.com.bicosonline.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.model.AreaTrabalho;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.support.Fachada;
@Named(value="anuncioEditCreateMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class AnuncioEditCreateMB {

	@Autowired
	private Fachada fachada;
	
	private Anuncio anuncio;
	
	private Pessoa empregador, intermediario, empregado;
	
	private List<AreaTrabalho> listaArea;

	private List<Pessoa> listaEmpregado, listaEmpregador, listaIntermediario;
	
	@PostConstruct
	public void init(){
		this.anuncio = new Anuncio();
		
	}
	
	public String salvar(){
		this.anuncio.setIsAberto(true);
		this.fachada.salvarAnuncio(this.anuncio);
		return "success";
	}
	
	public void editar(Anuncio a){
		this.anuncio = a;
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public List<AreaTrabalho> getListaArea() {
		return Arrays.asList(AreaTrabalho.values());
	}

	public void setListaArea(List<AreaTrabalho> listaArea) {
		this.listaArea = listaArea;
	}

	public List<Pessoa> getListaEmpregado() {
		this.listaEmpregado = fachada.listarEmpregados();
		return listaEmpregado;
	}

	public void setListaEmpregado(List<Pessoa> listaEmpregado) {
		this.listaEmpregado = listaEmpregado;
	}

	public List<Pessoa> getListaEmpregador() {
		this.listaEmpregador = fachada.listarEmpregadores();
		return listaEmpregador;
	}

	public void setListaEmpregador(List<Pessoa> listaEmpregador) {
		this.listaEmpregador = listaEmpregador;
	}

	public List<Pessoa> getListaIntermediario() {
		this.listaIntermediario = fachada.listarIntermediarios();
		return listaIntermediario;
	}

	public void setListaIntermediario(List<Pessoa> listaIntermediario) {
		this.listaIntermediario = listaIntermediario;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Pessoa intermediario) {
		this.intermediario = intermediario;
	}

	public Pessoa getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Pessoa empregado) {
		this.empregado = empregado;
	}

	public Pessoa getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Pessoa empregador) {
		this.empregador = empregador;
	}


}
