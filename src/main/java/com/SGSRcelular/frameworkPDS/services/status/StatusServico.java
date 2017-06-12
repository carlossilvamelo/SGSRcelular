package com.SGSRcelular.frameworkPDS.services.status;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.services.ServicoService;

@Component
public abstract class StatusServico{
	
	private ArrayList<StatusServico> proximosStatusPossiveis;
	
	private String nomeStatus;
	private ArrayList<String> nomesAcoesParaProximoStatus;
	
	public abstract StatusServico proximo();
	public abstract <T> T getInstancia();
	public abstract void executar(Consumer<ServicoService> metodo);

	public static StatusServico consultarStatusAtual(String nome, StatusServico statusInicial){
		
		
		while(statusInicial != null){
			if(statusInicial.getNomeStatus().equals(nome))
				return statusInicial;
			
			statusInicial = statusInicial.proximo();
			
		}
		return null;
	}


	public ArrayList<StatusServico> getProximosStatusPossiveis() {
		return proximosStatusPossiveis;
	}


	public void setProximosStatusPossiveis(ArrayList<StatusServico> proximosStatusPossiveis) {
		this.proximosStatusPossiveis = proximosStatusPossiveis;
	}


	public String getNomeStatus() {
		return nomeStatus;
	}


	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}


	public ArrayList<String> getNomesAcoesParaProximoStatus() {
		return nomesAcoesParaProximoStatus;
	}


	public void setNomesAcoesParaProximoStatus(ArrayList<String> nomesAcoesParaProximoStatus) {
		this.nomesAcoesParaProximoStatus = nomesAcoesParaProximoStatus;
	}


	
	
	
	
	
	
	
}
