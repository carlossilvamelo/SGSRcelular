package com.SGSRcelular.frameworkPDS.services;

import java.util.List;

import com.SGSRcelular.frameworkPDS.models.CheckIn;


public interface ICheckInService {

	public void inserir(CheckIn checkIn);

	List<CheckIn> buscarCheckInPorId(Integer idServico);

}
