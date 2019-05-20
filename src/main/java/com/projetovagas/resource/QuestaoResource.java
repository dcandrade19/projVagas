package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Questao;
import com.projetovagas.repository.QuestaoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/questoes")
public class QuestaoResource {
	
	@Autowired
	private QuestaoRepository repository;
	
	@RequestMapping("/questoes")
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Questao> listaVagas() {
		return repository.findAll();
	}

	@GetMapping("/questoes/{id}")
	public ResponseEntity<Questao> buscaVaga(@PathVariable long id) {
		return repository.findById(id)
				.map(res ->  ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/questoes")
	public Questao cadastraVaga(@RequestBody @Valid Questao questao) {
		return repository.save(questao);
	}
	
	@DeleteMapping("/questoes/{id}")
	public ResponseEntity<?> deletaVaga(@PathVariable long id) {
		return repository.findById(id)
           .map(data -> {
               repository.deleteById(id);
               return ResponseEntity.ok().body(data);
           }).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/questoes/{id}")
	public ResponseEntity<?> atualizaVaga(@PathVariable long id, @RequestBody Questao questao) {
		return repository.findById(id)
           .map(data -> {
			   data.setDescricao(questao.getDescricao());
			   data.setTeste(questao.getTeste());
               data.setRespostas(questao.getRespostas());
               Questao atualizada = repository.save(data);
               return ResponseEntity.ok().body(atualizada);
           }).orElse(ResponseEntity.notFound().build());
	}
}
