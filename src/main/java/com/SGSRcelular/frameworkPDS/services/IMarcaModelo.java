package com.SGSRcelular.frameworkPDS.services;


import java.util.List;

import com.SGSRcelular.frameworkPDS.models.MarcaModelo;

public interface IMarcaModelo {

	public MarcaModelo buscarPorMarcaModelo(String marca, String modelo);
	public List<String> buscarModelosPorMarca(String marca);
}
