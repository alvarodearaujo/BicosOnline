package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;
import br.com.bicosonline.support.UserLogadoController;

@Named(value="empregadorListMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class EmpregadorListMB {

	@Autowired
	private Fachada fachada;
	
	@Autowired
	private EmpregadorEditMB empregadorEditMB;
	
	private List<Pessoa> listaEmpregadores;
	
	public User usuario;
	
	
	
	@PostConstruct
	public void init(){
		this.listaEmpregadores = fachada.listarEmpregadores();
	}
	
	public void editar(Pessoa e){
		this.empregadorEditMB.editar(e);
	}

	public void excluir(Pessoa p){
		Endereco e = fachada.procurarEndereco(p);
		this.fachada.removerPessoa(p, e);
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Pessoa> getListaEmpregadores() {
		return listaEmpregadores;
	}

	public void setListaEmpregadores(List<Pessoa> listaEmpregadores) {
		this.listaEmpregadores = listaEmpregadores;
	}

	
}
