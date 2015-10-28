package br.com.bicosonline.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bicosonline.model.Anuncio;
import br.com.bicosonline.model.Pessoa;
import br.com.bicosonline.model.User;

public interface IPessoaDAO extends JpaRepository<Pessoa, Long>{
	public Pessoa findByCpf(String s);
	public List<Pessoa> findByIntermediario(Pessoa p);
	public Pessoa findByUsuario(User u);
	public Pessoa findByAnuncio(Anuncio a);
}
