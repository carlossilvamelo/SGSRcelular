package com.SGSRcelular.frameworkPDS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGSRcelular.frameworkPDS.models.Peca;


@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{

}
