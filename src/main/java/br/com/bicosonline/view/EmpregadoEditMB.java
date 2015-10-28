package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Estados;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;
@Named(value="empregadooEditMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class EmpregadoEditMB {

	@Autowired
	private Fachada fachada;
	
	private Pessoa pessoa,intermediario;
	
	private List<Sexo> listaSexo;
	
	private List<Estados> listaEstado;
	
	private Endereco endereco;
	
	private User user;
	
	private int nota;
	
	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
		this.endereco = new Endereco();
	}
	
	public String salvar(){
		this.user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
		this.intermediario = fachada.procurarPessoaUsuario(user);
		this.fachada.salvarEmpregado(this.pessoa, intermediario);
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


	public List<Sexo> getListaSexo() {
		return listaSexo;
	}

	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Estados> getListaEstados() {
		return listaEstado;
	}

	public void setListaEstados(List<Estados> listaEstados) {
		this.listaEstado = listaEstados;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Pessoa intermediario) {
		this.intermediario = intermediario;
	}

	public List<Estados> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<Estados> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}


	
}
