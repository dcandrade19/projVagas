package com.projetovagas.entity;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "vaga")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVaga;
	@Column(name = "nome")
	private String nome;
	@ManyToOne
	@JoinColumn(name = "empresa", referencedColumnName = "idUsuario")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
	private Empresa empresa;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "estado")
	private String estado;
	@Column(name = "periodo")
	private String periodo;
	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "testes")
	private Set<Teste> testes;

	public long getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(long idVaga) {
		this.idVaga = idVaga;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<Teste> getTestes() {
		return testes;
	}

	public void setTestes(Set<Teste> testes) {
		this.testes = testes;
	}

}
