package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Estados;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Named(value = "intermediarioAdmEditMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class IntermediarioAdmEditMB {

	@Autowired
	private Fachada fachada;

	private Pessoa pessoa;

	private List<Estados> listaEstado;

	private List<Sexo> listaSexo;
	
	private User usuario;

	@PostConstruct
	public void init() {
		this.pessoa = new Pessoa();
		this.usuario = new User();
	}

	public String salvar() {
		this.usuario.setRole("ROLE_USER");
		this.usuario.setNome(this.pessoa.getNome());
		this.usuario.setIntermediario(this.pessoa);
		this.fachada.salvarUsuario(this.usuario);
		
		this.pessoa.setIntermediario(true);
		this.fachada.salvarPessoa(this.pessoa);
		;
		return "success";
	}
	
	public void editar(Pessoa p){
		this.pessoa = p;
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Estados> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<Estados> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public List<Sexo> getListaSexo() {
		return listaSexo;
	}

	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}
