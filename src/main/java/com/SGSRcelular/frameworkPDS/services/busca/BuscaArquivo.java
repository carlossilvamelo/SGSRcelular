package com.SGSRcelular.frameworkPDS.services.busca;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.SGSRcelular.frameworkPDS.models.Peca;

public class BuscaArquivo extends Busca{

	private String diretorio;
	
	public BuscaArquivo(String diretorio){
		
		this.diretorio = diretorio;
	}
	
	@Override
	public List<Peca> buscaPeca() {
		
		List<Peca> pecas = new ArrayList<Peca>();
		
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader(diretorio))
			        .useDelimiter("\\:|\\n");//separa por quebra de linha e por :
			String nome = "";
			String preco = "";
			
			while (scanner.hasNext()) {
				
				String linha = scanner.next();

				if(linha.contains("DESCRICAO")){
					
					nome = scanner.next();
					System.out.println(nome);
					
				}else if(linha.contains("PRECO UNITARIO")){
					
					preco = scanner.next();
					
					Peca peca = new Peca();
					peca.setNome(nome);
					peca.setPreco(preco.replace(" TOTAL", ""));
					pecas.add(peca);
				}
				
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pecas.forEach(p -> System.out.println(p.getNome()));
			
		return pecas;
	}

}
