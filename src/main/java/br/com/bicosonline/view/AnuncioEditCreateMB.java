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
	
	private Pessoa empregador;
	
	private List<AreaTrabalho> listaArea;

	private List<Pessoa>  listaEmpregador;
	
	@PostConstruct
	public void init(){
		this.anuncio = new Anuncio();
		
	}
	
	public String salvar(){
		this.anuncio.setIsAberto(true);
		this.anuncio.setAnunciante(this.empregador);
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

	public List<Pessoa> getListaEmpregador() {
		this.listaEmpregador = fachada.listarEmpregadores();
		return listaEmpregador;
	}

	public void setListaEmpregador(List<Pessoa> listaEmpregador) {
		this.listaEmpregador = listaEmpregador;
	}

	public Pessoa getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Pessoa empregador) {
		this.empregador = empregador;
	}

}
