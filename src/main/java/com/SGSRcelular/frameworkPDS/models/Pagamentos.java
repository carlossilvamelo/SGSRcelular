package com.SGSRcelular.frameworkPDS.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pagamentos {
	@Id
	@GeneratedValue
	private Integer id;
	private Cliente cliente;
	private String formaPagamento;
	private Calendar DataPagamento;
	private String resumoServico;
	private String modeloVeiculo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Calendar getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
		DataPagamento = dataPagamento;
	}
	public String getResumoServico() {
		return resumoServico;
	}
	public void setResumoServico(String resumoServico) {
		this.resumoServico = resumoServico;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
}
