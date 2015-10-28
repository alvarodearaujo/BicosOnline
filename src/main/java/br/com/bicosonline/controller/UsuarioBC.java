package br.com.bicosonline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bicosonline.model.User;
import br.com.bicosonline.model.repository.IUserDAO;

@RequestMapping("/testing")
@Controller
public class UsuarioBC {

	@Autowired
	private IUserDAO dao;

	public void salvarUsuario(User usuario) {
		this.dao.save(usuario);
	}

	public void excluirUsuario(User usuario) {
		dao.delete(usuario);
	}

	public List<User> listarUsuario() {
		return dao.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String testMestod(HttpServletRequest request){
	    request.getSession().setAttribute("name", "value");
	    return "testJsp";
	}
	
}
