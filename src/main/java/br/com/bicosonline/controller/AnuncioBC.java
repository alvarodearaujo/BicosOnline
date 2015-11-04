package br.com.bicosonline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.model.repository.IAnuncioDAO;

@Controller
public class AnuncioBC {
	
	@Autowired
	private IAnuncioDAO dao;
	
	@Autowired
	private PessoaBC pessoaBC;
	
	@Autowired
	private EnderecoBC enderecoBC;
	
	public void salvarAnuncio(Anuncio a){
		dao.save(a);
	}
	
	public void removerAnuncio(Anuncio a){
		dao.delete(a);
	}
	
	public List<Anuncio> listarAnunciosAbertos(){
		List<Anuncio> listaAnuncios = new ArrayList<Anuncio>(), listaAux ;
		listaAux = dao.findAll();
		for(Anuncio a : listaAux){
			if(a.isIsAberto() == true){
				a.setPessoa(this.pessoaBC.procuraPessoaAnuncio(a));
				a.getPessoa().setEndereco(enderecoBC.procurarEndereco(a.getPessoa()));
				listaAnuncios.add(a);
			}
		}
		return listaAnuncios;
	}
	
	public List<Anuncio> listarAnunciosFechados(){
		List<Anuncio> listaAnuncios = new ArrayList<Anuncio>(), listaAux ;
		listaAux = dao.findAll();
		for(Anuncio a : listaAux){
			if(a.isIsAberto() == false){
				listaAnuncios.add(a);
			}
		}
		return listaAnuncios;
	}
	
	public List<Anuncio> listarAnuncios(){
		List<Anuncio> listaAnuncios = new ArrayList<Anuncio>(), listaAux ;
		listaAux = dao.findAll();
		for(Anuncio a : listaAux){
				a.getPessoa().setEndereco(enderecoBC.procurarEndereco(a.getPessoa()));
				listaAnuncios.add(a);
		}
		return listaAnuncios;
	}
	
}
