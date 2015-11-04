package br.com.bicosonline.view;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Estados;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.Sexo;
import br.com.bicosonline.model.User;
import br.com.bicosonline.support.Fachada;

@Named(value = "intermediarioAdmEditMB")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class IntermediarioAdmEditMB {

	@Autowired
	private Fachada fachada;

	private Pessoa pessoa;

	private List<Estados> listaEstado;

	private List<Sexo> listaSexo;

	private User usuario, usuarioAtual;

	private Endereco endereco;

	private Date dataNascimento;

	private LocalDate data;

	@PostConstruct
	public void init() {
		this.pessoa = new Pessoa();
		this.usuario = new User();
		this.usuarioAtual = new User();
		this.endereco = new Endereco();

	}

	public String salvar() {
		if (this.fachada.procurarPorLogin(this.usuario.getLogin()) == null) {
			// Verificando se já existe alguém cadastrado com o CPF e que seja
			// Intermediario
			if (this.fachada.procurarPorCpf(this.pessoa.getCpf()) == null) {
				this.pessoa.setIntermediario(true);

				this.setData(dataNascimento);
				this.pessoa.setDataNascimento(data);
				this.fachada.salvarPessoa(this.pessoa);

				this.endereco.setPessoa(pessoa);
				this.fachada.salvarEndereco(this.endereco);

				this.usuario.setRole("USER_ROLE");
				this.usuario.setNome(this.pessoa.getNome());
				this.usuario.gerarNovaSenha();
				this.usuario.setEmail(this.pessoa.getEmail());
				this.usuario.setIntermediario(this.pessoa);
				try {
					this.fachada.salvarUsuario(this.usuario);
				} catch (EmailException e) {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao Enviar E-mail",
							"E-mail com o envio do Login e Senha do Usuário Falhou.");
					FacesContext.getCurrentInstance().addMessage(null, message);

				}
				return "success";
			} else if (this.fachada.procurarPorCpf(this.pessoa.getCpf()).isIntermediario() != true) {
				Pessoa pessoaEncontrada = this.fachada.procurarPorCpf(this.pessoa.getCpf());
				pessoaEncontrada.setIntermediario(true);

				this.fachada.salvarPessoa(pessoaEncontrada);

				this.usuario.setRole("USER_ROLE");
				this.usuario.setNome(pessoaEncontrada.getNome());
				this.usuario.gerarNovaSenha();
				this.usuario.setEmail(pessoaEncontrada.getEmail());
				this.usuario.setIntermediario(pessoaEncontrada);
				
				try {
					this.fachada.salvarUsuario(this.usuario);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "success";
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no Cadastro",
						"Já existe um intermediário com o CPF informado.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "failed";
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no Usuário",
					"Já existe usuário com o login informado.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "failed";
		}

	}

	public String salvarEditar() {
			String login = this.usuarioAtual.getLogin();
		if (this.usuario.getLogin().equals(login)) {
			this.setData(dataNascimento);
			this.pessoa.setDataNascimento(data);
			this.fachada.salvarPessoa(this.pessoa);

			this.endereco.setPessoa(pessoa);
			this.fachada.salvarEndereco(this.endereco);
			
			return "success";
			
		} else if(this.fachada.procurarPorLogin(this.usuario.getLogin()) == null){
			this.setData(dataNascimento);
			this.pessoa.setDataNascimento(data);
			this.fachada.salvarPessoa(this.pessoa);

			this.endereco.setPessoa(pessoa);
			this.fachada.salvarEndereco(this.endereco);

			this.usuario.setIntermediario(this.pessoa);
			try {
				this.fachada.salvarUsuario(this.usuario);
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

	public void editar(Pessoa p) {
		this.pessoa = p;
		this.endereco = fachada.procurarEndereco(p);
		this.setLocalData(p.getDataNascimento());
		this.usuario = fachada.procurarUserPorPessoa(p);
		this.usuarioAtual = fachada.procurarUserPorPessoa(p);
	}

	public void setData(Date date) {
		Instant instant = date.toInstant();
		this.data = instant.atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public void setLocalData(LocalDate ld) {
		this.dataNascimento = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
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

	public List<Estados> getListaEstado() {
		return Arrays.asList(Estados.values());
	}

	public void setListaEstado(List<Estados> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public List<Sexo> getListaSexo() {
		return Arrays.asList(Sexo.values());
	}

	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
