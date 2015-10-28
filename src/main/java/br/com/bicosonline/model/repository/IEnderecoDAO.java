package br.com.bicosonline.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bicosonline.model.Endereco;
import br.com.bicosonline.model.Pessoa;

public interface IEnderecoDAO extends JpaRepository<Endereco,Long>{
	public Endereco findByPessoa(Pessoa p);
}
