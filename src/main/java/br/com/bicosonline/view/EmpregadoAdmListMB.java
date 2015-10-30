package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Named(value = "empregadoAdmListMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmpregadoAdmListMB {

	@Autowired
	private Fachada fachada;

	@Autowired
	private EmpregadoAdmEditMB empregadoAdmEditMB;

	private List<Pessoa> listaEmpregados;

	@PostConstruct
	public void init() {
		this.listaEmpregados = fachada.listarEmpregados();
	}

	public void classificar(Pessoa p) {
		this.empregadoAdmEditMB.editar(p);
		;
	}

	public void excluir(Pessoa p) {
		Endereco e = fachada.procurarEndereco(p);
		this.fachada.removerPessoa(p, e);
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public EmpregadoAdmEditMB getEmpregadoEditMB() {
		return empregadoAdmEditMB;
	}

	public void setEmpregadoEditMB(EmpregadoAdmEditMB empregadoAdmEditMB) {
		this.empregadoAdmEditMB = empregadoAdmEditMB;
	}

	public List<Pessoa> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(List<Pessoa> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}

}
