package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Estados;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Named(value = "intermediarioEditMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class IntermediarioEditMB {

	@Autowired
	private Fachada fachada;

	private Pessoa intermediario;

	private List<Estados> listaEstado;

	private List<Sexo> listaSexo;
	
	private User usuario;

	@PostConstruct
	public void init() {
		this.usuario = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
		this.intermediario = fachada.procurarPessoaUsuario(usuario);
	}

	public String salvar() {
		try {
			this.fachada.salvarUsuario(this.usuario);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fachada.salvarPessoa(this.intermediario);
		return "success";
	}
	
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Pessoa pessoa) {
		this.intermediario = pessoa;
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
