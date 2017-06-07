package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.MarcaModelo;
import com.SGSRcelular.frameworkPDS.models.Celular;


public interface ICelularService {
	
	//acesso ao banco
	public void inserir(Celular produto);
	
	public void deletar(Celular produto);
	public void deletePorId(Integer idProduto);
	
	public Celular buscarPorId(Integer id);
	public List<Celular> buscarTodos();

	public void deleteAlertasProduto(Celular produto);

	public void deletarTodos(Celular produto);
	
	public List<String> buscarModelosPorMarca(String marca);
	
	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo);
	
	public List<String> buscarMarcas();
	

	
	
	
}
