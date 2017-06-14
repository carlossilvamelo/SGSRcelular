package com.SGSRcelular.frameworkPDS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRcelular.frameworkPDS.models.Peca;


@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{

	@Query("SELECT p FROM Peca p WHERE p.nome = :nome AND p.quantidade > 0 ")
	public Peca verificarDisponibilidade(@Param("nome") String nome);
	
	@Query("SELECT p FROM Peca p WHERE p.nome = :nome")
	public Peca buscarPorNome(@Param("nome") String nome);

}
