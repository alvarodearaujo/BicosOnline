package br.com.bicosonline.support;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bicosonline.controller.AnuncioBC;
import br.com.bicosonline.controller.ClassificacaoBC;
import br.com.bicosonline.controller.EnderecoBC;
import br.com.bicosonline.controller.PessoaBC;
import br.com.bicosonline.controller.UsuarioBC;
import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.model.Classificacao;
import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;

@Component
public class Fachada {
	
	//Pessoa
	@Autowired
	private PessoaBC pessoaBC;
	
	public void salvarPessoa(Pessoa p){
		this.pessoaBC.SalvarPessoa(p);
	}
	
	public void removerPessoa(Pessoa p, Endereco e){
		this.pessoaBC.ExcluirPessoa(p, e);
	}
	
	public void salvarEmpregado(Pessoa a, Pessoa b){
		this.pessoaBC.salvarEmpregado(a, b);
	}
	
	public Pessoa procurarPessoa(Pessoa p){
		return this.pessoaBC.procurarPessoa(p);
	}
	
	public Pessoa procurarPessoaUsuario(User u){
		return this.pessoaBC.procurarPessoaUsuario(u);
	}
	
	public Pessoa procuraPessoaAnuncio(Anuncio a){
		return this.pessoaBC.procuraPessoaAnuncio(a);
	}
	
	public Pessoa procurarPorCpf(String s){
		return this.pessoaBC.procurarPessoaCpf(s);
	}
	
	public List<Pessoa> listarMeusEmpregados(Pessoa p){
		return this.pessoaBC.listarMeusEmpregados(p);
	}
	
	public List<Pessoa> listarEmpregados(){
		return this.pessoaBC.listarEmpregados();
	}
	
	public List<Pessoa> listarEmpregadores(){
		return this.pessoaBC.listarEmpregadores();
	}
	
	public List<Pessoa> listarIntermediarios(){
		return this.pessoaBC.listarIntermediarios();
	}
	
	
	
	//Anuncio
	@Autowired
	private AnuncioBC anuncioBC;
	
	public void salvarAnuncio(Anuncio a){
		anuncioBC.salvarAnuncio(a);
	}
	
	public void removerAnuncio(Anuncio a){
		anuncioBC.removerAnuncio(a);
	}
	
	public List<Anuncio> listarAnuncios(){
		return anuncioBC.listarAnuncios();
	}
	
	public List<Anuncio> listarAnunciosAbertos(){
		return anuncioBC.listarAnunciosAbertos();
	}
	
	public List<Anuncio> listarAnunciosFechados(){
		return anuncioBC.listarAnunciosFechados();
	}
	
	//Endereço
	@Autowired
	private EnderecoBC enderecoBC;
	
	public void salvarEndereco (Endereco e){
		this.enderecoBC.salvarEndereco(e);
	}
	
	public void removerEndereco (Endereco e){
		this.enderecoBC.removerEndereco(e);
	}
	
	public Endereco procurarEndereco(Pessoa p){
		return this.enderecoBC.procurarEndereco(p);
	}
	
	// Usuario
		@Autowired
		private UsuarioBC usuarioBC;

		public void salvarUsuario(User usuario) throws EmailException {
			this.usuarioBC.salvarUsuario(usuario);
		}

		public void removerUsuario(User usuario) {
			this.usuarioBC.excluirUsuario(usuario);
		}

		public List<User> listarUsuario() {
			return this.usuarioBC.listarUsuario();
		}
		
		public User procurarPorLogin(String login){
			return this.usuarioBC.procurarPorLogin(login);
		}
		
		public User procurarUserPorPessoa(Pessoa p){
			return this.usuarioBC.procurarPorPessoa(p);
		}
		
	//Classificacao
		@Autowired ClassificacaoBC classificacaoBC;
		
		public void classificar(Classificacao c){
			this.classificacaoBC.salvarClassificacao(c);
		}
		
		public int getClassificacao(Pessoa p){
			return this.classificacaoBC.getClassificacao(p);
		}
}
