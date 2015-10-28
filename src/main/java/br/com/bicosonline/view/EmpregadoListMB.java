package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Named(value="empregadoListMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class EmpregadoListMB {

	@Autowired
	private Fachada fachada;
	
	@Autowired
	private EmpregadoEditMB empregadoEditMB;
	
	private List<Pessoa> listaEmpregados;
	
	private Pessoa intermediario;
	
	private User user;
	
	@PostConstruct
	public void init(){
		this.user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
		this.intermediario = fachada.procurarPessoaUsuario(user);
		this.listaEmpregados = fachada.listarMeusEmpregados(intermediario);
	}
	
	public void editar(Pessoa p){
		this.empregadoEditMB.editar(p);;
	}

	public void excluir(Pessoa p){
		this.fachada.removerPessoa(p);
	}
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public EmpregadoEditMB getEmpregadoEditMB() {
		return empregadoEditMB;
	}

	public void setEmpregadoEditMB(EmpregadoEditMB empregadoEditMB) {
		this.empregadoEditMB = empregadoEditMB;
	}

	public List<Pessoa> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(List<Pessoa> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Pessoa intermediario) {
		this.intermediario = intermediario;
	}
	
}
