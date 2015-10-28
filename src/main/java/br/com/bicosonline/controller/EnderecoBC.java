package br.com.bicosonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.repository.IEnderecoDAO;

@Controller
public class EnderecoBC {

	@Autowired
	private IEnderecoDAO dao;
	
	private Endereco endereco;
	
	public void salvarEndereco(Endereco e){
		this.dao.save(e);
	}
	
	public void removerEndereco(Endereco e){
		this.dao.delete(e);
	}
	
	public Endereco procurarEndereco(Pessoa p){
		return this.dao.findByPessoa(p);
	}

	public IEnderecoDAO getDao() {
		return dao;
	}

	public void setDao(IEnderecoDAO dao) {
		this.dao = dao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
