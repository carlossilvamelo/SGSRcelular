package com.SGSRcelular.frameworkPDS.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class CheckIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_checkin")
	private Integer id;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dataHora;
	private String acao;
	private Integer classificacao;
	private String descricao;
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_acompanhamento")
	private Acompanhamento acompanhamento;
	
	public CheckIn() {
	}
	
	public CheckIn(Integer id, Date dataHora, String acao) {
		this.id = id;
		this.dataHora = dataHora;
		this.acao = acao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public Integer getClassficacao() {
		return classificacao;
	}

	public void setClassficacao(Integer classficacao) {
		this.classificacao = classficacao;
	}

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
