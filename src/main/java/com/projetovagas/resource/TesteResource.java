package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Teste;
import com.projetovagas.repository.TesteRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/testes")
public class TesteResource {
	
	@Autowired
	private TesteRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Teste> listaTestes() {
		Iterable<Teste> listaTestes = repository.findAll();
		return listaTestes;
	}
	
	@PostMapping()
	public Teste cadastraTeste(@RequestBody @Valid Teste teste) {
		return repository.save(teste);
	}
	
	@DeleteMapping()
	public Teste deletaTeste(@RequestBody Teste teste) {
		repository.delete(teste);
		return teste;
	}
	
	@PutMapping()
	public Teste atualizaTeste(@RequestBody Teste teste) {
		repository.save(teste);
		return teste;
	}

}
