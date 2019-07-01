package com.projetovagas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="resultado")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idResultado;
	@ManyToOne
	@JoinColumn(name="candidato_id", referencedColumnName="idUsuario")
	@JsonBackReference(value ="resultadosCandidato")
	private Candidato candidato;
	@ManyToOne
	@JoinColumn(name="teste_id", referencedColumnName="idTeste")
	@JsonBackReference(value="resultadosTeste")
	private Teste teste;
	private int nota;
	
	public long getIdResultado() {
		return idResultado;
	}
	public void setIdResultado(long idResultado) {
		this.idResultado = idResultado;
	}
	public Candidato Candidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Teste getTeste() {
		return teste;
	}
	public void setTeste(Teste teste) {
		this.teste = teste;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}

	
}
