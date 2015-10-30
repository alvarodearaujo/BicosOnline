package br.com.bicosonline.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "usuarioListMB")
public class UsuarioListMB {

	@Inject
	private Fachada fachada;
	
	@Autowired
	private UsuarioEditMB editMB;
	
	
	private List<User> listaUser;

	@PostConstruct
	private void init() {
		setListaUser(listarUser());
	}

	private List<User> listarUser() {
		return fachada.listarUsuario();
	}

	public void excluir(User User) {
		fachada.removerUsuario(User);
		setListaUser(listarUser());
	}
	
	public void editar(User User){
		editMB.preAlterar(User);
	}
	public List<User> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<User> listaUser) {
		this.listaUser = listaUser;
	}

}
