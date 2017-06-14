package com.SGSRcelular.frameworkPDS.services;


import com.SGSRcelular.frameworkPDS.models.Pagamentos;
import com.SGSRcelular.frameworkPDS.models.Servico;

public interface IPagamentosService {
	public void salvarPagamento(Pagamentos pagamento);
	public boolean processarPagamentoCredito(Pagamentos pagamento, Servico servico);
	public boolean processarPagamentoBoleto(Pagamentos pagamento, Servico servico);
	public boolean processarPagamentoDebito(Pagamentos pagamento);
}
