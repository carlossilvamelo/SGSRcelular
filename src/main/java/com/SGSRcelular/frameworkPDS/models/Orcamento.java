package com.SGSRcelular.frameworkPDS.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Orcamento implements Serializable{
	

	private static final long serialVersionUID = -3329162767984686645L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_orcamento")
	private Long id;
	private Double precoMaoObra;
	private String obs;
	private Double valorTotal;
	private Double valorAdicional;
	private Double descontoValor;
	private Integer descontoPorcentagem;
	private boolean pago = false;
	@OneToMany
	private List<Peca> pecas;
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_servico")
	private Servico servico;

	
	public Orcamento() {
		pago = false;
		valorTotal = 0.0;
		valorAdicional = 0.0;
		descontoValor = 0.0;
		descontoPorcentagem = 0;
		precoMaoObra = 0.0;
	}
	
	
	public Double getDescontoValor() {
		return descontoValor;
	}

	public void setDescontoValor(Double descontoValor) {
		this.descontoValor = descontoValor;
	}

	public Integer getDescontoPorcentagem() {
		return descontoPorcentagem;
	}

	public void setDescontoPorcentagem(Integer descontoPorcentagem) {
		this.descontoPorcentagem = descontoPorcentagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}


	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public Double getPrecoMaoObra() {
		return precoMaoObra;
	}

	public void setPrecoMaoObra(Double precoMaoObra) {
		this.precoMaoObra = precoMaoObra;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}


	public List<Peca> getPecas() {
		return pecas;
	}


	public void setPecas() {
		this.pecas =new ArrayList<Peca>();
	}
	
	public void addPeca(Peca peca){
		
		
		pecas.add(peca);
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public boolean getPago() {
		return pago;
	}


	public void setPago(boolean pago) {
		this.pago = pago;
	}
}
