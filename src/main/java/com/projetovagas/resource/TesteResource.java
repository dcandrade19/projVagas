package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Teste;
import com.projetovagas.repository.TesteRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class TesteResource {
	
	@Autowired
	private TesteRepository repository;
	
	@RequestMapping("/testes")
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Teste> listaVagas() {
		return repository.findAll();
	}

	@GetMapping("/testes/{id}")
	public ResponseEntity<Teste> buscaVaga(@PathVariable long id) {
		return repository.findById(id)
				.map(res ->  ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/testes")
	public Teste cadastraVaga(@RequestBody @Valid Teste teste) {
		return repository.save(teste);
	}
	
	@DeleteMapping("/testes/{id}")
	public ResponseEntity<?> deletaVaga(@PathVariable long id) {
		return repository.findById(id)
           .map(data -> {
               repository.deleteById(id);
               return ResponseEntity.ok().body(data);
           }).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/testes/{id}")
	public ResponseEntity<?> atualizaVaga(@PathVariable long id, @RequestBody Teste teste) {
		return repository.findById(id)
           .map(data -> {
			   data.setTitulo(teste.getTitulo());
			   data.setVaga(teste.getVaga());
               data.setQuestoes(teste.getQuestoes());
               data.setResultadosTeste(teste.getResultadosTeste());
               Teste atualizada = repository.save(data);
               return ResponseEntity.ok().body(atualizada);
           }).orElse(ResponseEntity.notFound().build());
	}

}
