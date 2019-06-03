package com.projetovagas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="resultado")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idResultado;
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="idUsuario")
	@JsonBackReference(value ="resultadosUsuario")
	private Usuario usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
