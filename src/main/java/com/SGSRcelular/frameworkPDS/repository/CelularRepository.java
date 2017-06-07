package com.SGSRcelular.frameworkPDS.repository;

import java.util.ArrayList;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRcelular.frameworkPDS.models.Celular;


@Transactional
@Repository
public interface CelularRepository extends JpaRepository<Celular, Integer>{
	
	
	@Query("SELECT p FROM  Celular p WHERE p.id = :id")
	ArrayList<Celular> listarPorId(@Param("id") Integer id);
	
	@Modifying
	@Query("DELETE FROM Celular p WHERE p.id = :id")
	void deletePorId(@Param("id") Integer id);

}
