package br.com.bicosonline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.model.repository.IPessoaDAO;

@Controller
public class PessoaBC {
	
	@Autowired
	private IPessoaDAO dao;
	
	@Autowired
	private EnderecoBC enderecoBC;
	
	public void SalvarPessoa(Pessoa p){
		this.dao.save(p);
	}
	
	public void ExcluirPessoa(Pessoa p){
		this.dao.delete(p);
	}
	
	public void salvarEmpregado(Pessoa a, Pessoa b){
		a.setIntermediario(b);
		a.setIntermediario(true);
		this.SalvarPessoa(a);
	}
	
	public Pessoa procuraPessoaAnuncio(Anuncio a){
		return this.dao.findByAnuncio(a);
	}
	
	public Pessoa procurarPessoa(Pessoa p){
		return this.dao.findOne(p.getId());
	}
	
	public Pessoa procurarPessoaUsuario(User u){
		return this.dao.findByUsuario(u);
	}
	
	public Pessoa procurarPessoaCpf(String s){
		return this.dao.findByCpf(s);
	}
	
	public List<Pessoa> listarMeusEmpregados(Pessoa p){
		return this.dao.findByIntermediario(p);
	}
	
	public List<Pessoa> listarEmpregados(){
		
		List<Pessoa> listaEmpregados, listaPessoas;
		listaEmpregados = new ArrayList<Pessoa>();
		
		listaPessoas = this.dao.findAll();
		for(Pessoa a : listaPessoas ){
			if(a.isEmpregado()){
				a.setEndereco(this.enderecoBC.procurarEndereco(a));
				listaEmpregados.add(a);
			}
		}
		return listaEmpregados; 
	}
	
public List<Pessoa> listarEmpregadores(){
		
		List<Pessoa> listaEmpregadores, listaPessoas;
		listaEmpregadores = new ArrayList<Pessoa>();
		
		listaPessoas = this.dao.findAll();
		for(Pessoa e : listaPessoas ){
			if(e.isEmpregador()){
				e.setEndereco(this.enderecoBC.procurarEndereco(e));
				listaEmpregadores.add(e);
			}
		}

		return listaEmpregadores; 
}

public List<Pessoa> listarIntermediarios(){
	
	List<Pessoa> listaIntermediarios, listaPessoas;
	listaIntermediarios = new ArrayList<Pessoa>();
	
	listaPessoas = this.dao.findAll();
	for(Pessoa i : listaPessoas ){
		if(i.isIntermediario()){
			i.setEndereco(this.enderecoBC.procurarEndereco(i));
			listaIntermediarios.add(i);
		}
	}
	return listaIntermediarios; 
}

public IPessoaDAO getDao() {
	return dao;
}

public void setDao(IPessoaDAO dao) {
	this.dao = dao;
}

public EnderecoBC getEnderecoBC() {
	return enderecoBC;
}

public void setEnderecoBC(EnderecoBC enderecoBC) {
	this.enderecoBC = enderecoBC;
}

}
