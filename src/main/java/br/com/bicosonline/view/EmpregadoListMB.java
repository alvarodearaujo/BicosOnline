package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;
import br.com.bicosonline.support.UserLogadoController;

@Named(value="empregadoListMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class EmpregadoListMB {

	@Autowired
	private Fachada fachada;
	
	@Autowired
	private EmpregadoEditMB empregadoEditMB;
	
	@Autowired
	private UserLogadoController uc;   
	
	private List<Pessoa> listaEmpregados;
	
	private Pessoa intermediario;
	
	private User user;
	
	
	@PostConstruct
	public void init(){
		uc = new UserLogadoController();
		this.user = uc.getUsuario();
		this.intermediario = fachada.procurarPessoaUsuario(user);
		this.listaEmpregados = fachada.listarMeusEmpregados(intermediario);
	}
	
	public void editar(Pessoa p){
		this.empregadoEditMB.editar(p);;
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
