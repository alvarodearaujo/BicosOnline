package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Email;
import br.com.bicosonline.support.Fachada;

@Named(value="indicacaoMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)	
public class IndicacaoMB {

	@Autowired
	private Fachada fachada;
	
	@Autowired
	private DialogView dialogView;
	
	@Autowired
	private Email email;
	
	private List<Pessoa> listaEmpregados, selecionados;
	
	private Anuncio anuncio;
	
	private Pessoa intermediario, empregador;
	
	private User user;
	
	@PostConstruct
	public void init(){
		
		this.user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
		this.intermediario = fachada.procurarPessoaUsuario(user);
		this.listaEmpregados = fachada.listarMeusEmpregados(intermediario);
		
		this.anuncio = new Anuncio();
	}
	
	public void indicar(Anuncio a){
		this.anuncio = a;
		this.empregador = fachada.procuraPessoaAnuncio(a);
	}
	
	public void adicionar(Pessoa p){
		this.selecionados.add(p);
		this.dialogView.confirmaAdicionamento();
	}
	
	public String concluir(){
		if(!listaEmpregados.isEmpty()){
			try {
				this.email.sendEmailIndicacao(this.listaEmpregados, this.empregador);
				this.dialogView.confirmacaoIdicacao();
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "success";
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Pessoa> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(List<Pessoa> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}


	public List<Pessoa> getSelecionados() {
		return selecionados;
	}


	public void setSelecionados(List<Pessoa> selecionados) {
		this.selecionados = selecionados;
	}

	public DialogView getDialogView() {
		return dialogView;
	}

	public void setDialogView(DialogView dialogView) {
		this.dialogView = dialogView;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Pessoa getPessoa() {
		return intermediario;
	}

	public void setPessoa(Pessoa pessoa) {
		this.intermediario = pessoa;
	}

	public Pessoa getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Pessoa empregador) {
		this.empregador = empregador;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
