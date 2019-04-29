package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Questao;
import com.projetovagas.repository.QuestaoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/questoes")
public class QuestaoResource {
	
	@Autowired
	private QuestaoRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Questao> listaQuestoes() {
		Iterable<Questao> listaQuestoes = repository.findAll();
		return listaQuestoes;
	}
	
	@PostMapping()
	public Questao cadastraQuestao(@RequestBody @Valid Questao questao) {
		return repository.save(questao);
	}
	
	@DeleteMapping()
	public Questao deletaQuestao(@RequestBody Questao questao) {
		repository.delete(questao);
		return questao;
	}
	
	@PutMapping()
	public Questao atualizaQuestao(@RequestBody Questao questao) {
		repository.save(questao);
		return questao;
	}

}
