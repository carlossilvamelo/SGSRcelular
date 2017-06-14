package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.Orcamento;
import com.SGSRcelular.frameworkPDS.models.Peca;


public interface ILojaService {
	public Loja buscarPorId(String id);
	public void inserir(Loja prestadora);
	public void deletar(Loja prestadora);
	public List<Loja> buscarTodos();
	Orcamento gerarOrcamento(List<Peca> pecas);
	boolean verificarDisponibilidade(Peca peca);
	List<Peca> buscarPecaArquivo(String diretorio);
	void cadastrarPecasSite(String diretorio);
}
