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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idQuestao;
	private String descricao;
	@ManyToOne
	@JoinColumn(name="teste_id", referencedColumnName="idTeste")
	@JsonBackReference(value="questoes")
	private Teste teste;
	@OneToMany(mappedBy = "questao", cascade = CascadeType.ALL)
	@JsonManagedReference(value="respostas")
	private Set<Resposta> respostas;
	
	public long getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
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
