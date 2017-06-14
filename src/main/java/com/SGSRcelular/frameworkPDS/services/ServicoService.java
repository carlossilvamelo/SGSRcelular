package com.SGSRcelular.frameworkPDS.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.CheckIn;
import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.Orcamento;
import com.SGSRcelular.enumeracoes.EnumStatus;
import com.SGSRcelular.frameworkPDS.models.Celular;
import com.SGSRcelular.frameworkPDS.models.Servico;
import com.SGSRcelular.frameworkPDS.repository.CheckInRepository;
import com.SGSRcelular.frameworkPDS.repository.OrcamentoRepository;
import com.SGSRcelular.frameworkPDS.repository.ServicoRepository;


@Service
public class ServicoService implements IServicoService{

	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private CheckInRepository checkInRepository;
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	/**
	 * Requisito gera uma atualização do status do serviço
	 * 
	 * 
	 * @param idServico
	 */
	
	@Override
	public List<Servico> buscarServicosPorContratante(Cliente contratante) {
		return servicoRepository.listarServicoPorContratante(contratante);
	}
	
	@Override
	public List<Servico> buscarServicosPorPrestadora(Loja prestadora) {
		return servicoRepository.listarServicoPorPrestadora(prestadora);
	}

	@Override
	public void inserir(Servico servico) {
		servicoRepository.save(servico);
	}

	@Override
	public void deletar(Servico servico) {
		servicoRepository.delete(servico);
	}
	
	

	@Override
	public Servico buscarPorId(Integer id) {
		return servicoRepository.getOne(id);
	}

	@Override
	public List<Servico> buscarTodos() {
		return servicoRepository.findAll();
	}


	@Override
	public List<Servico> buscarServicosPorIdContratante(String idCliente) {
		return null;
	}
	
	@Override
	public void atualizarProduto(Celular produto) {
		servicoRepository.updateCelular(produto);
	}

	@Override
	public List<CheckIn> listarCheckIn(Integer id) {
		// TODO Auto-generated method stub
		return checkInRepository.listarCheckInPorServico(id);
	}
	
	@Override
	public void verificarServico(Integer id){
		
		/*Servico servi = servicoRepository.findOne(id);
		
		for (CheckIn checkin : servi.getCheckIns()) {
			
			if(checkin.getClassficacao() == 0){
				servicoRepository.delete(servi);
			}
			
		}*/
	}

	@Override
	public void deletarTodos(Celular produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void proximoStatus(Integer idServico) {
		Servico ServicoAtualizado = buscarPorId(idServico);
		int status = ServicoAtualizado.getStatus().ordinal() + 1;
		ServicoAtualizado.setStatus(EnumStatus.fromInteger(status));
		inserir(ServicoAtualizado);
	}
	
	@Override
	public void aprovarOrcamentoServico(Integer idServico){
		Servico ServicoAtualizado = buscarPorId(idServico);
		ServicoAtualizado.setStatus(EnumStatus.SERVICO_AUTORIZADO);
		inserir(ServicoAtualizado);
	}
	
	@Override
	public void vistoriaPendente(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.VISTORIA_PENDENTE);
		inserir(servicoAtualizado);
	}
	
	@Override
	public void naoAutorizado(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.SERVICO_NAO_AUTORIZADO);
		inserir(servicoAtualizado);
	}
	
	@Override
	public void aguardandoPecas(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_PECAS);
		inserir(servicoAtualizado);
	}

	@Override
	public void aguardandoCliente(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_CLIENTE);
		inserir(servicoAtualizado);
	}

	@Override
	public void emAndamento(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.EM_ANDAMENTO);
		inserir(servicoAtualizado);
	}

	@Override
	public void finalizado(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.FINALIZADO);
		inserir(servicoAtualizado);
	}
	
	public void inserirOrcamento(Orcamento orcamento){
		
		orcamentoRepository.save(orcamento);
	
	}
	

}