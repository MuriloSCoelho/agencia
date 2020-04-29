package br.com.qintess.agencia.repository;
  
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.agencia.models.Carro;
  
  @Repository 
  public interface CarroRepository extends JpaRepository<Carro, Integer>{

	void save(Optional<Carro> carro);

	/* Carro buscaPorMarca(String marca); */
	
  }
 