package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.CheckIn;
import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.Celular;
import com.SGSRcelular.frameworkPDS.models.Servico;


public interface IServicoService {

	public List<Servico> buscarServicosPorIdContratante(String contratante);
	
	//acesso ao banco
	public void inserir(Servico servico);
	public void deletar(Servico servico);
	public Servico buscarPorId(Integer id);
	public List<Servico> buscarTodos();
	public List<Servico> buscarServicosPorContratante(Cliente contratante);
	public List<Servico> buscarServicosPorPrestadora(Loja prestadora);
	public void atualizarProduto(Celular produto);
	public void deletarTodos(Celular produto);
	public List<CheckIn> listarCheckIn(Integer id);
	public void verificarServico(Integer id);

	void proximoStatus(Integer idServico);

	void aprovarOrcamentoServico(Integer idServico);

	void vistoriaPendente(Integer idServico);

	void naoAutorizado(Integer idServico);

	void aguardandoPecas(Integer idServico);

	void aguardandoCliente(Integer idServico);

	void emAndamento(Integer idServico);

	void finalizado(Integer idServico);
	
	
	
}