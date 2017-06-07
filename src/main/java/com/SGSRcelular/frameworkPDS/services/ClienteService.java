package com.SGSRcelular.frameworkPDS.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	//@Autowired
	//private LogicaAcompanhamento logicaAcompanhamento;
	
	@Override
	public void verificaProduto(String idContratante) {
	}
	
	@Override
	public Cliente buscarPorId(String id) {
		Cliente contratante = null;
		try {
			contratante = clienteRepository.findOne(id);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
		return contratante;	
	}
	
	@Override
	public void inserir(Cliente cliente) {
		try {
			clienteRepository.save(cliente);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
	}
	@Override
	public void deletar(Cliente contratante) {
		try {
			clienteRepository.delete(contratante);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
	}


	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> contratantes = null;
		try {
			contratantes = clienteRepository.findAll();
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
		return contratantes;
	}

	@Override
	public Cliente buscarID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
