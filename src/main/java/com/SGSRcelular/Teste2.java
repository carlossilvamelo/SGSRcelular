package com.SGSRcelular;


import com.SGSRcelular.frameworkPDS.services.busca.BuscaArquivo;

public class Teste2 {


	
	public static void main(String args[]){
		
		BuscaArquivo arq = new BuscaArquivo("C://pecas//BASTOS_14-06-2017.txt");
		arq.buscaPeca();
	}
		
}
