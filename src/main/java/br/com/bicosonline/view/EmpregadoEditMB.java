package br.com.bicosonline.view;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Estados;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;
import br.com.bicosonline.support.UserLogadoController;
@Named(value="empregadoEditMB")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class EmpregadoEditMB {

	@Autowired
	private Fachada fachada;
	
	private Pessoa pessoa,intermediario;
	
	private List<Sexo> listaSexo;
	
	private List<Estados> listaEstado;
	
	private Endereco endereco;
	
	private User user;
	
	private Date dataNascimento;

	private LocalDate data;
	
	private int nota;
	
	private UserLogadoController uc;   
	
	
	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
		this.endereco = new Endereco();
		uc = new UserLogadoController();
		this.user = uc.getUsuario();
	}
	
	public String salvar(){
		this.intermediario = fachada.procurarPessoaUsuario(user);
		
		//Setando a data de nascimento
		this.setData(dataNascimento);
		this.pessoa.setDataNascimento(data);
		
		//Salvando o empregado
		this.fachada.salvarEmpregado(this.pessoa, intermediario);
		
		//Salvando o endereço
		this.endereco.setPessoa(this.pessoa);
		this.fachada.salvarEndereco(this.endereco);
		
		return "success";
	}
	
	public void editar(Pessoa p) {
		this.pessoa = p;
		this.setEndereco(pessoa.getEndereco());
	}
	
	public void setData(Date date) {
		Instant instant = date.toInstant();
		this.data = instant.atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Pessoa getIntermediario() {
		return intermediario;
	}

	public User getUser() {
		return user;
	}

	public int getNota() {
		return nota;
	}

	public void setIntermediario(Pessoa intermediario) {
		this.intermediario = intermediario;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public List<Sexo> getListaSexo() {
		return  Arrays.asList(Sexo.values());
	}

	public List<Estados> getListaEstado() {
		return  Arrays.asList(Estados.values());
	}

	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public void setListaEstado(List<Estados> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public UserLogadoController getUc() {
		return uc;
	}

	public void setUc(UserLogadoController uc) {
		this.uc = uc;
	}

	
}
