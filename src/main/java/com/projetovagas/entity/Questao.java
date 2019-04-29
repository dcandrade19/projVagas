package com.projetovagas.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="teste_id", referencedColumnName="id")
	private Teste teste;
	@JsonManagedReference
	@OneToMany(mappedBy = "questao", cascade = CascadeType.ALL)
	private Set<Resposta> respostas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Teste getTeste() {
		return teste;
	}
	public void setTeste(Teste teste) {
		this.teste = teste;
	}
	public Set<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}
		
}
