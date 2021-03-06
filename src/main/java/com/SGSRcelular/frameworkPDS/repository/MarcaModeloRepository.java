package com.SGSRcelular.frameworkPDS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRcelular.frameworkPDS.models.MarcaModelo;

@Repository
public interface MarcaModeloRepository extends JpaRepository<MarcaModelo, Long>{

	@Query("SELECT m.modelo FROM MarcaModelo m WHERE m.marca =:marca ")
	public List<String> buscarModelosPorMarca(@Param("marca")String marca);
	
	@Query("SELECT m FROM MarcaModelo m WHERE m.marca =:marca AND m.modelo =:modelo")
	public MarcaModelo buscarPorMarcaModelo(@Param("marca")String marca, @Param("modelo")String modelo);
	
	
	@Query("SELECT DISTINCT(m.marca) FROM MarcaModelo m ")
	public List<String> buscarMarcas();

	
}
