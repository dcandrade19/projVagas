package com.projetovagas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idResposta;
	private String descricao;
	private Boolean certa;
	
	@ManyToOne
	@JoinColumn(name="questao_id", referencedColumnName="idQuestao")
	@JsonBackReference(value="respostas")
	private Questao questao;
	
	
	public long getIdResposta() {
		return idResposta;
	}
	public void setIdResposta(long idResposta) {
		this.idResposta = idResposta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getCerta() {
		return certa;
	}
	public void setCerta(Boolean certa) {
		this.certa = certa;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
}
