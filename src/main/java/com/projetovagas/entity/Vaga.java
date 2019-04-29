package com.projetovagas.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="vaga")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="nome")
	private String nome;
	@Column(name="testes")
	@JsonManagedReference
	@OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
	private Set<Teste> testes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Teste> getTestes() {
		return testes;
	}
	public void setTestes(Set<Teste> testes) {
		this.testes = testes;
	}
}
