package br.com.bicosonline.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "usuarioEditMB")
public class UsuarioEditMB {

	@Autowired
	private Fachada fachada;

	private User usuario;

	@PostConstruct
	private void init() {
		usuario = new User();
	}

	public void preAlterar(User usuario) {
		this.usuario = usuario;
	}

	public String salvar() {
		if(this.fachada.procurarPorLogin(this.usuario.getLogin()) == null){
			this.usuario.setRole("MASTER_ROLE");
			try {
				fachada.salvarUsuario(usuario);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no Usuário",
					"Já existe usuário com o login informado.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "failed";
		}
		
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

}
