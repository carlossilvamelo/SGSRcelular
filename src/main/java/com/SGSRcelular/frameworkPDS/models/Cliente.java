package com.SGSRcelular.frameworkPDS.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat; 

@Entity
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_cliente")
	private String id;
	private String nome;
	private String telefone;
	private String telefoneAlt;
	private String email;
	private String sexo;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Celular> celulares  = new ArrayList<Celular>();
	
	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private Endereco endereco;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataNascimento;

	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private List<Servico> servicos = new ArrayList<Servico>();
	
	
	

	public Cliente(){};
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefoneAlt() {
		return telefoneAlt;
	}
	public void setTelefoneAlt(String telefoneAlt) {
		this.telefoneAlt = telefoneAlt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public List<Servico> getServicos() {
		return servicos;
	}


	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	public void adicionarServico(Servico servico) {
		this.servicos.add(servico);
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Servico> getServico() {
		return servicos;
	}
	public void setServico() {
		this.servicos = new ArrayList<Servico>();
	}
	public void addServico(Servico servico){
		this.servicos.add(servico);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public List<Celular> getCelulares() {
		return celulares;
	}


	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}


	public void addCelular(Celular celular) {
		this.celulares.add(celular);
		
	}


	
	


}