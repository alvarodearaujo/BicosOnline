package br.com.bicosonline.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bicosonline.model.Anuncio;


public interface IAnuncioDAO extends JpaRepository<Anuncio,Long>{

}
