package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.Orcamento;
import com.SGSRcelular.frameworkPDS.models.Peca;
import com.SGSRcelular.frameworkPDS.repository.LojaRepository;
import com.SGSRcelular.frameworkPDS.repository.PecaRepository;
import com.SGSRcelular.frameworkPDS.services.busca.BuscaArquivo;


@Service
public class LojaService implements ILojaService{
	
	@Autowired
	private LojaRepository lojaRepository;
	@Autowired
	private PecaRepository pecaRepository;
	
	private BuscaArquivo buscaArquivo;
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
	
	@Override
	public Orcamento gerarOrcamento(List<Peca> pecas){
		
		List<Peca> novasPecas;
		Orcamento novoOrcamento = new Orcamento();
		
		for (Peca peca : pecas) {
			
			if(pecaRepository.verificarDisponibilidade(peca.getNome()) == null){
				
				novoOrcamento.addPeca(peca);
				
			}
			
		}
		
		return novoOrcamento;
	}
	
	@Override
	public boolean verificarDisponibilidade(Peca peca){
		
		pecaRepository.verificarDisponibilidade(peca.getNome());
		
		return false;
		
	}

	@Override
	public List<Peca> buscarPecaArquivo(String diretorio) {
		
		
		buscaArquivo = new BuscaArquivo(diretorio);
		
		return buscaArquivo.buscarPecaMenorPreco();
	}

	@Override
	public void cadastrarPecasSite(String diretorio) {
		
		try{
			List<Peca> pecas = buscarPecaArquivo(diretorio);
			
			for (Peca peca : pecas) {
				
				if(pecaRepository.verificarDisponibilidade(peca.getNome()) == null){
					
					pecaRepository.save(peca);
				}
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

}
