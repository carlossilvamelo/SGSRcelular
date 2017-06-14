package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.Peca;



public interface IPecaService {

	//acesso ao banco
	public void inserir(Peca peca);
	public void deletar(Peca peca);
	public List<Peca> buscarTodos();
	public Peca buscarPorId(Long id);
	public Peca buscarPorNome(String nome);
}
