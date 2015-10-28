package br.com.bicosonline.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bicosonline.model.Classificacao;
import br.com.bicosonline.model.Pessoa;

public interface IClassificacao extends JpaRepository<Classificacao, Long>{
	public List<Classificacao> findByPessoa(Pessoa p);
}
