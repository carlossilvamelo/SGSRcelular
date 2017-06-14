package com.SGSRcelular.frameworkPDS.services;

import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.Orcamento;

@Service
public class ContadorServicoCelular extends ContadorServico{

	@Override
	public Double addDescontoPorcentagem(Double valor, Orcamento orcamento) {
		Double valorDesconto = (double) orcamento.getDescontoPorcentagem();
		valorDesconto = valor * (valorDesconto/100);
		valor = valor - valorDesconto;
		return valor;
	}

	@Override
	public Double taxasSobreValor(Double valor) {
		//taxa de serviços de TI
		return valor * 1.1;
	}

	@Override
	public Double contabilizarValorProprio(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return null;
	}
}
