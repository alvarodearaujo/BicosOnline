package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.support.Fachada;

@Named(value = "anuncioListMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AnuncioListMB {

	@Autowired
	private Fachada fachada;

	@Autowired
	private IndicacaoMB indicacaoMB;

	public void indicar(Anuncio a) {
		this.indicacaoMB.indicar(a);
	}

	private List<Anuncio> listaAnuncio;

	@PostConstruct
	public void init() {
		this.listaAnuncio = fachada.listarAnuncios();
	}

	public List<Anuncio> getListaAnuncio() {
		this.listaAnuncio = this.fachada.listarAnunciosAbertos();
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

	public IndicacaoMB getIndicacaoMB() {
		return indicacaoMB;
	}

	public void setIndicacaoMB(IndicacaoMB indicacaoMB) {
		this.indicacaoMB = indicacaoMB;
	}

}