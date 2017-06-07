package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.Peca;
import com.SGSRcelular.frameworkPDS.repository.PecaRepository;


@Service
public class PecaServiceF implements IPecaService{

	@Autowired
	private PecaRepository pecaRepository;
	
	@Override
	public void inserir(Peca peca) {
		pecaRepository.save(peca);
	}

	@Override
	public void deletar(Peca peca) {
		pecaRepository.delete(peca);
	}

	@Override
	public List<Peca> buscarTodos() {
		return pecaRepository.findAll();
	}

	@Override
	public Peca buscarPorId(Long id) {
		return pecaRepository.getOne(id);
	}

	

}
