package com.projetovagas.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.projetovagas.entity.Vaga;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.projetovagas.repository.VagaRepository;

@CrossOrigin
@RestController
public class VagaResource {
	
	@Autowired
	private VagaRepository repository;
	@RequestMapping("/vagas")
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Vaga> listaVagas() {
		Iterable<Vaga> listaVagas = repository.findAll();
		return listaVagas;
	}

	@GetMapping("/vaga/{id}")
	public Optional<Vaga> buscaVaga(@PathVariable long id) {
		System.out.print(id);
		Optional<Vaga> vaga = repository.findById(id);
		return vaga;
	}
	
	@PostMapping()
	public Vaga cadastraVaga(@RequestBody @Valid Vaga vaga) {
		return repository.save(vaga);
	}
	
	@DeleteMapping()
	public Vaga deletaVaga(@RequestBody Vaga vaga) {
		repository.delete(vaga);
		return vaga;
	}
	
	@PutMapping()
	public Vaga atualizaVaga(@RequestBody Vaga vaga) {
		repository.save(vaga);
		return vaga;
	}

}
