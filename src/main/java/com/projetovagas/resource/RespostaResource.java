package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Resposta;
import com.projetovagas.repository.RespostaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/respostas")
public class RespostaResource {
	
	@Autowired
	private RespostaRepository repository;
	
	@RequestMapping("/respostas")
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Resposta> listaVagas() {
		return repository.findAll();
	}

	@GetMapping("/respostas/{id}")
	public ResponseEntity<Resposta> buscaVaga(@PathVariable long id) {
		return repository.findById(id)
				.map(res ->  ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/respostas")
	public Resposta cadastraVaga(@RequestBody @Valid Resposta resposta) {
		return repository.save(resposta);
	}
	
	@DeleteMapping("/respostas/{id}")
	public ResponseEntity<?> deletaVaga(@PathVariable long id) {
		return repository.findById(id)
           .map(data -> {
               repository.deleteById(id);
               return ResponseEntity.ok().body(data);
           }).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/respostas/{id}")
	public ResponseEntity<?> atualizaVaga(@PathVariable long id, @RequestBody Resposta resposta) {
		return repository.findById(id)
           .map(data -> {
			   data.setDescricao(resposta.getDescricao());
			   data.setCerta(resposta.getCerta());
               data.setQuestao(resposta.getQuestao());
               Resposta atualizada = repository.save(data);
               return ResponseEntity.ok().body(atualizada);
           }).orElse(ResponseEntity.notFound().build());
	}

}
