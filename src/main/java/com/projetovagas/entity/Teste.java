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
	private long idTeste;
	@Column(name="titulo")
	private String titulo;
	@ManyToOne
	@JoinColumn(name="vaga_id", referencedColumnName="idVaga")
	@JsonBackReference(value ="testes")
	private Vaga vaga;
	@OneToMany(mappedBy = "teste", cascade = CascadeType.ALL)
	@JsonManagedReference(value="questoes")
	private Set<Questao> questoes;
	@OneToMany(mappedBy = "teste", cascade = CascadeType.ALL)
	@JsonManagedReference(value="resultadosTeste")
	private Set<Resultado> resultadosTeste;
	
	
	public long getIdTeste() {
		return idTeste;
	}
	public void setIdTeste(long idTeste) {
		this.idTeste = idTeste;
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
	public Set<Resultado> getResultadosTeste() {
		return resultadosTeste;
	}
	public void setResultadosTeste(Set<Resultado> resultadosTeste) {
		this.resultadosTeste = resultadosTeste;
	}
	
	
}
