package com.SGSRcelular.frameworkPDS.services;

import java.util.ArrayList;
import java.util.List;

import com.SGSRcelular.frameworkPDS.models.Cliente;


public interface IClienteService {
	
	public Cliente buscarID(String id);
	public Cliente buscarPorId(String id);
	public void inserir(Cliente contratante);
	public void deletar(Cliente contratante);
	public List<Cliente> buscarTodos();
	void verificaProduto(String cpf);
}
