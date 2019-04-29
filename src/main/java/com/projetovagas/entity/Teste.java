package com.projetovagas.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Teste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="titulo")
	private String titulo;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="vaga_id", referencedColumnName="id")
	private Vaga vaga;
	@JsonManagedReference
	@OneToMany(mappedBy = "teste", cascade = CascadeType.ALL)
	private Set<Questao> questoes;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	public Set<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}
	
}
