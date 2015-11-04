package br.com.bicosonline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;
import br.com.bicosonline.model.repository.IUserDAO;
import br.com.bicosonline.support.Email;

@RequestMapping("/testing")
@Controller
public class UsuarioBC {

	@Autowired
	private IUserDAO dao;

	public void salvarUsuario(User usuario) throws EmailException {
		this.dao.save(usuario);
		Email email = new Email();
		email.sendEmailUsuario(usuario);
	}

	public void excluirUsuario(User usuario) {
		dao.delete(usuario);
	}

	public List<User> listarUsuario() {
		List<User> aux = dao.findAll();
		List<User> usuarios = new ArrayList<User>();
		for(User u : aux){
			if(u.getRole().equals("MASTER_ROLE")){
				usuarios.add(u);
			}
		}
		return usuarios;
	}
	
	public User procurarPorLogin(String login){
		return this.dao.findByLogin(login);
	}
	
	public User procurarPorPessoa(Pessoa p){
		return this.dao.findByIntermediario(p);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String testMestod(HttpServletRequest request){
	    request.getSession().setAttribute("name", "value");
	    return "testJsp";
	}
	
}
