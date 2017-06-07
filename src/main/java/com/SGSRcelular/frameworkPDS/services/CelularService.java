package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGSRcelular.frameworkPDS.models.MarcaModelo;
import com.SGSRcelular.frameworkPDS.models.Celular;
import com.SGSRcelular.frameworkPDS.repository.CelularRepository;
import com.SGSRcelular.frameworkPDS.repository.MarcaModeloRepository;



@Service
public class CelularService implements ICelularService{

	@Autowired
	private CelularRepository celularRepository;
	
	@Autowired
	private MarcaModeloRepository modeloRepository;
	

	@Override
	public void inserir(Celular celular) {
		celularRepository.save(celular);
	}

	@Override
	public Celular buscarPorId(Integer id) {
		return celularRepository.findOne(id);
	}
	@Override
	public void deletarTodos(Celular produto) {
		
		/*for(Servico serv: produto.getServicos()){
			servicoRepository.delete(serv);
		}*/
		
	}
	@Override
	public List<Celular> buscarTodos() {
		return celularRepository.findAll();
	}
	
	@Override
	public void deletar(Celular produto) {
		celularRepository.delete(produto);
	}
	
	@Override
	public void deletePorId(Integer idProduto) {
		
		celularRepository.deletePorId(idProduto);
	}
	
	@Override
	public void deleteAlertasProduto(Celular produto) {
		//TODO criar esse método
		
		//dataFacade.getAlertaRepository().deleteByTipoAlerta(veiculo);
	}

	@Override
	public List<String> buscarModelosPorMarca(String marca) {
		// TODO Auto-generated method stub
		return modeloRepository.buscarModelosPorMarca(marca);
	}

	@Override
	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo) {
		// TODO Auto-generated method stub
		return modeloRepository.buscarPorMarcaModelo(marca, modelo);
	}

	@Override
	public List<String> buscarMarcas() {
		// TODO Auto-generated method stub
		return modeloRepository.buscarMarcas();
	}

	
	

}
