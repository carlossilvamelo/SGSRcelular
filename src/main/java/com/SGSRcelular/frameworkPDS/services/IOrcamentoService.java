package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.Orcamento;


public interface IOrcamentoService {

	//acesso ao banco
	public void inserir(Orcamento orcamento);
	public void deletar(Orcamento orcamento);
	public List<Orcamento> buscarTodos();
	public Orcamento buscarPorId(Long id);
}
