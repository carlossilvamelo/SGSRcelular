package com.SGSRcelular.frameworkPDS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGSRcelular.frameworkPDS.models.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{
	
	
}
