package br.com.bicosonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.bicosonline.model.Classificacao;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.repository.IClassificacao;

@Controller
public class ClassificacaoBC {
	
	@Autowired
	private IClassificacao dao;
	
	public void salvarClassificacao(Classificacao c){
		this.dao.save(c);
	}
	
	public int getClassificacao(Pessoa p){
		List<Classificacao> listaClassificacao = this.dao.findByPessoa(p);
		int quantidadeTotal = 0, notas =0;
		for(Classificacao cla: listaClassificacao){
			notas += cla.getNota();
			quantidadeTotal++ ;
		}
		return(notas/quantidadeTotal);
	}
	
}
