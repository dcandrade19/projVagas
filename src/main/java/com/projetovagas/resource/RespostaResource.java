package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Resposta;
import com.projetovagas.repository.RespostaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/respostas")
public class RespostaResource {
	
	@Autowired
	private RespostaRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Resposta> listaRespostas() {
		Iterable<Resposta> listaRespostas = repository.findAll();
		return listaRespostas;
	}
	
	@PostMapping()
	public Resposta cadastraResposta(@RequestBody @Valid Resposta resposta) {
		return repository.save(resposta);
	}
	
	@DeleteMapping()
	public Resposta deletaResposta(@RequestBody Resposta resposta) {
		repository.delete(resposta);
		return resposta;
	}
	
	@PutMapping()
	public Resposta atualizaResposta(@RequestBody Resposta resposta) {
		repository.save(resposta);
		return resposta;
	}

}
