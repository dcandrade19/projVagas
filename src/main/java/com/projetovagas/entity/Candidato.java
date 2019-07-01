package com.projetovagas.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("Candidato")
@PrimaryKeyJoinColumn(name="idUsuario")
public class Candidato extends Usuario {

	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
	@JsonManagedReference(value="resultadosCandidato")
	private Set<Resultado> resultadosCandidato;

	public Set<Resultado> getResultadosCandidato() {
		return resultadosCandidato;
	}
	public void setResultadosCandidato(Set<Resultado> resultadosCandidato) {
		this.resultadosCandidato = resultadosCandidato;
	}
	
}
