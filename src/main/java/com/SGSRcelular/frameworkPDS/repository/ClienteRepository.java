package com.SGSRcelular.frameworkPDS.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRcelular.frameworkPDS.models.Cliente;



@Transactional
@Repository
//Spring Data JPA creates an implementation on the fly
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
}

