package br.com.bicosonline.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends EntidadeBase<Long> {

	private static final long serialVersionUID = 201404140102L;

	private String nome;

	private String login;

	private String password;

	private String role;
	
	@OneToOne
	private Pessoa intermediario;

	public User() {
	}

	public User(String nome, String login, String password, String role) {
		super();
		this.nome = nome;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Pessoa intermediario) {
		this.intermediario = intermediario;
	}

}
