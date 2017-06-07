package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.repository.LojaRepository;


@Service
public class LojaService implements ILojaService{
	
	@Autowired
	private LojaRepository lojaRepository;
	//@Autowired
	//private LogicaAcompanhamento logicaAcompanhamento;
	
	@Override
	public void inserir(Loja loja) {
		lojaRepository.save(loja);
	}

	@Override
	public void deletar(Loja loja) {
		lojaRepository.delete(loja);
	}

	@Override
	public Loja buscarPorId(String id) {
		return lojaRepository.findOne(id);
	}

	@Override
	public List<Loja> buscarTodos() {
		return lojaRepository.findAll();
	}

}
