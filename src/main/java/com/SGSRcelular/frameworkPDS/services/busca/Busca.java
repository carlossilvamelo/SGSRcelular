package com.SGSRcelular.frameworkPDS.services.busca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.SGSRcelular.frameworkPDS.models.Peca;

@Component
public abstract class Busca {

	private List<Peca> pecas;

	public Busca(){
		
		pecas = new ArrayList<Peca>();
	}
	
	
	private final List<Peca> menorPreco(List<Peca> listaPecas){
		
		listaPecas.stream()
		.filter((p)-> p.getPreco() != null)
		.sorted((p1, p2)->p1.getPreco().compareTo(p2.getPreco()));

		return listaPecas;
		
	}
	

	
	public final List<Peca> buscarPecaMaisAvaliado(String idValor, String idProduto) {

		return maisAvaliado(buscaPeca());
	}
	
	
	public final List<Peca> buscarPecaMenorPreco(String idValor, String idProduto){

		return menorPreco(buscaPeca());
	}


	private final List<Peca> maisAvaliado(List<Peca> listaPecas) {
		
		listaPecas.stream()
		.filter((p)-> p.getAvaliacao() != null)
		.sorted((p1, p2)->p2.getAvaliacao().compareTo(p1.getAvaliacao()));

		return listaPecas;
	}

	
	public List<Peca> buscaPeca(){
		
		return pecas;	
	}

	

}
