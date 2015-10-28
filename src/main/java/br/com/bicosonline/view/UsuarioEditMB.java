package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

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
		this.usuario.setRole("MASTER_USER");
		fachada.salvarUsuario(usuario);
		return "success";
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
