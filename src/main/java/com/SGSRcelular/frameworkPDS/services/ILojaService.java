package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.Loja;


public interface ILojaService {
	public Loja buscarPorId(String id);
	public void inserir(Loja prestadora);
	public void deletar(Loja prestadora);
	public List<Loja> buscarTodos();
}
