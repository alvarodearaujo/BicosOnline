package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.support.Fachada;

@Named(value = "anuncioAdmListMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AnuncioAdmListMB {

	@Autowired
	private Fachada fachada;

	@Autowired
	private AnuncioEditMB anuncioEditMB;
	
	@Autowired
	private AnuncioEditCreateMB anuncioEditCreateMB;
	

	private List<Anuncio> listaAnuncio;

	@PostConstruct
	public void init() {
		this.listaAnuncio = fachada.listarAnuncios();
	}
	
	public void editar(Anuncio a){
		this.anuncioEditCreateMB.editar(a);
	}
	
	public void finalizar(Anuncio a) {
		this.anuncioEditMB.editar(a);
	}
	
	public void excluir(Anuncio a){
		this.fachada.removerAnuncio(a);
	}

	public List<Anuncio> getListaAnuncio() {
		this.listaAnuncio = this.fachada.listarAnuncios();
		return listaAnuncio;
	}

	public void setListaAnuncio(List<Anuncio> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

}
